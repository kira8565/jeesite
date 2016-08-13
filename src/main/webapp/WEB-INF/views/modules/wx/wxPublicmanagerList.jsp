<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>微信公众号管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function () {

        });
        function page(n, s) {
            $("#pageNo").val(n);
            $("#pageSize").val(s);
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/wx/wxPublicmanager/">微信公众号列表</a></li>
    <shiro:hasPermission name="wx:wxPublicmanager:edit">
        <li><a href="${ctx}/wx/wxPublicmanager/form">微信公众号添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="wxPublicmanager" action="${ctx}/wx/wxPublicmanager/" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>名称：</label>
            <form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
        </li>
        <li><label>微信号：</label>
            <form:input path="wxname" htmlEscape="false" maxlength="45" class="input-medium"/>
        </li>
        <li><label>公众号类别：</label>
            <form:select path="wxtypes" class="input-medium">
                <form:option value="" label=""/>
                <form:options items="${fns:getDictList('wx_public')}" itemLabel="label" itemValue="value"
                              htmlEscape="false"/>
            </form:select>
        </li>
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
        <li class="clearfix"></li>
    </ul>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>名称</th>
        <th>微信号</th>
        <th>原始ID</th>
        <th>APPID</th>
        <th>应用密钥</th>
        <th>Token</th>
        <th>AESKey</th>
        <th>公众号类别</th>
        <th>更新时间</th>
        <th>备注信息</th>
        <th>消息加密方式</th>
        <shiro:hasPermission name="wx:wxPublicmanager:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="wxPublicmanager">
        <tr>
            <td><a href="${ctx}/wx/wxPublicmanager/form?id=${wxPublicmanager.id}">
                    ${wxPublicmanager.name}
            </a></td>
            <td>
                    ${wxPublicmanager.wxname}
            </td>
            <td>
                    ${wxPublicmanager.rawid}
            </td>
            <td>
                    ${wxPublicmanager.appid}
            </td>
            <td>
                    ${wxPublicmanager.appsecret}
            </td>
            <td>
                    ${wxPublicmanager.token}
            </td>
            <td>
                    ${wxPublicmanager.aesKey}
            </td>
            <td>
                    ${fns:getDictLabel(wxPublicmanager.wxtypes, 'wx_public', '')}
            </td>
            <td>
                <fmt:formatDate value="${wxPublicmanager.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>
                    ${wxPublicmanager.remarks}
            </td>
            <td>
                    ${fns:getDictLabel(wxPublicmanager.wxEncodeWay, 'wx_encode_way', '')}
            </td>
            <shiro:hasPermission name="wx:wxPublicmanager:edit">
                <td>
                    <a href="${ctx}/wx/wxPublicmanager/form?id=${wxPublicmanager.id}">修改</a>
                    <a href="javascript:void(0)" onclick="showWxLink('${wxPublicmanager.id}')">显示链接</a>
                    <a href="${ctx}/wx/wxPublicmanager/delete?id=${wxPublicmanager.id}"
                       onclick="return confirmx('确认要删除该微信公众号吗？', this.href)">删除</a>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>

<script>
    function showWxLink(id) {
        top.$.jBox.info('${baseCtx}/f/wx/wxauth/index'+id);
    }
</script>
</body>
</html>