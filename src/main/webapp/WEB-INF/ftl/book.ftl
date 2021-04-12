<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书列表</title>
    <link rel="stylesheet" href="/assets/css/index.css">
    <link rel="stylesheet" href="/assets/web/css/bootstrap.css">
</head>

<body>
<header>
    <#include 'nav.ftl'>
</header>
<section class="banner">
    <div class="container">
        <div>
            <h1>图书</h1>
            <p>图书列表</p>
        </div>
    </div>
</section>
<section class="main">
    <div class="container">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>名称</th>
                <th>分类</th>
                <th>创建时间</th>
                <th>最后修改时间</th>
            </tr>
            </thead>
            <tbody>
            <#list books as n>
                <tr>
                    <th>${n.name}</th>
                    <th>${n.category}</th>
                    <td>${n.createTime?datetime?string("dd-MM-yyyy")}</td>
                    <td>${n.updateTime?datetime?string("dd-MM-yyyy")}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</section>
<section class="page">
    <div class="container">
        <div id="fatie">
            <a href="">
                <button>新建</button>
            </a>
        </div>
    </div>
</section>
<footer>
    copy@慕课网
</footer>
</body>
</html>