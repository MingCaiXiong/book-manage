<div class="container">
    <#list nav as n>
        <nav>
            <a href="/book/list?cid=${n.id}">${n}</a>
        </nav>
    </#list>
    <nav>
        <a href="/book/list">All</a>
    </nav>
</div>