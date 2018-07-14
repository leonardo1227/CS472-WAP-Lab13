$(function () {
     let products = $('.product');
     $.each(products, function (index,value) {
         let product = $(value);
         product.mouseover(function () {
             $(this).css({'border-color':'blue'});
         });
         product.mouseout(function () {
             $(this).css({'border-color':'black'});
         });
     });
});