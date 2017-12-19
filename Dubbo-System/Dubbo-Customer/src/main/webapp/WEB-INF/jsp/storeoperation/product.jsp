<div class="container-fluid">
    <div class="side-body">
        <div class="row">
            <div class="col-xs-12">
                <div class="card">
                    <div class="card-header">
                        <div class="card-title">
                            <div class="title">商品列表</div>
                        </div>
                    </div>
                    <div class="card-body">
                        <table class="datatable table table-striped" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th style="text-align: center">ID</th>
                                <th style="text-align: center">商品名称</th>
                                <th style="text-align: center">商品现价</th>
                                <th style="text-align: center">商品原价</th>
                                <th style="text-align: center">商品说明</th>
                                <th style="text-align: center">商品图片</th>
                                <th style="text-align: center">库存数量</th>
                                <th style="text-align: center">星评</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th style="text-align: center">ID</th>
                                <th style="text-align: center">商品名称</th>
                                <th style="text-align: center">商品现价</th>
                                <th style="text-align: center">商品原价</th>
                                <th style="text-align: center">商品说明</th>
                                <th style="text-align: center">商品图片</th>
                                <th style="text-align: center">库存数量</th>
                                <th style="text-align: center">星评</th>
                            </tr>
                            </tfoot>
                            <tbody>

                            <c:forEach items="${STOREPRODUCT}" var="item">
                                <tr>
                                    <td>${item.id}</td>
                                    <td>${item.productName}</td>
                                    <td>${item.productPrice}</td>
                                    <td>${item.productOrprice}</td>
                                    <td>${item.productDesc}</td>
                                    <td>${item.productImage}</td>
                                    <td>${item.productNum}</td>
                                    <td>${item.productStars}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </div>
</div>