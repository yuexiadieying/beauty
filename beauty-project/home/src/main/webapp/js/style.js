/**
 * Created by Administrator on 2018/1/8.
 */
var bg = $(".bgColor");
bg.eq(0).addClass("active");
var h = $(".banner").height();
var gc = $(".college").height();

console.log(h);

$(".college div").height(gc)
$(".business div").height(gc)
function position(index){

    if(index == 1){
        $("html , body").animate({ scrollTop : h+'px' } , 500);
    }else if(index==0){
        $("html , body").animate({ scrollTop : '0px' } , 500);
    }
    else{
        $("html , body").animate({ scrollTop : gc*(index-1)+h+'px' } , 500);
    }
    bg.removeClass("active");
    bg.eq(index).addClass("active")

}

window.onresize = function ()
{
    h = $(".swiper-container img").height();
    gc = $(".college").height();
}



var swiper = new Swiper('.swiper-container', {
    pagination: '.swiper-pagination',
    paginationClickable: true,
    autoplay:3000,/*--每秒中轮播一次*/
    loop:true,/*--可以让图片循环轮播*/
    autoplayDisableOnInteraction : false
});


