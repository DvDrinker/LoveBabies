var goodsId = GetQueryString("goodsId");
// 放大镜
$(".minpic").mousemove(function(e){
	$(".move").css("display","block");
	$(".maxpic").css("display","block");

	var ev = window.event || e;
	var x = ev.pageX - $(".minpic")[0].offsetLeft - ($(".move")[0].offsetWidth)/2;
	var y = ev.pageY - $(".minpic")[0].offsetTop - ($(".move")[0].offsetHeight)/2;
	if(x < 0){
		x = 0;
	}
	if(x > $(".view")[0].offsetWidth - $(".move")[0].offsetWidth){
		x = $(".view")[0].offsetWidth - $(".move")[0].offsetWidth;
	}
	if(y < 0){
		y = 0;
	}
	if(y > $(".view")[0].offsetHeight - $(".move")[0].offsetHeight){
		y = $(".view")[0].offsetHeight - $(".move")[0].offsetHeight;
	}

	$(".move")[0].style.top = y + "px";
	$(".move")[0].style.left = x + "px";

	var scaleX = parseInt(1.6 * x);
	var scaleY = parseInt(1.6 * y);
	$(".maxpic")[0].style.background = 'url(../img/goodsDetailsimg/goods_big.jpg) ' + -scaleX + 'px ' + -scaleY + 'px '+ 'no-repeat'

})
$(".minpic").mouseout(function(){
	$(".move").css("display","none");
	$(".maxpic").css("display","none");
})

// 下面的小图片轮播
$(".before").click(function(){
	$(".picsbox")[0].style.left = "0px";
})
$(".next").click(function(){
	$(".picsbox")[0].style.left = "-300px";
})
// 下面小图片的放大效果
$(".item_pic").each(function(){
	$(this).on("mousemove",function(){
		$(".minpic").css("background","url(../img/goodsDetailsimg/goods1.jpg) 0 0 no-repeat");
	})
})

// 加减按钮
$(".add").click(function(){
	var newnum = Number($(".num").val()) + 1;
	if(newnum >= $(".savenum").text()){
		newnum = $(".savenum").text();
	}
	$(".num").val(newnum);
})

$(".reduce").click(function(){
	var newnum = Number($(".num").val()) - 1;
	if(newnum < 0){
		newnum = 0;
	}
	$(".num").val(newnum);
})

// 选择商品信息

goodsClick($(".w_goods"));
goodsClick($(".c_goods"));
function goodsClick(event){
	var last = 0;
	event.each(function(index){
		$(this).click(function(){
			$(this).addClass("cur");
			event.eq(last).removeClass("cur");
			last = index;
			$(".checkword").text($(".cur").text());
		})
	})
}
$(".checkword").text($(".cur").text());

// 点赞
$(".praise").click(function(){
	$(".praise").css("background","url(../img/goodsDetailsimg/mind.png) 0 -18px no-repeat");
})

// 分享
$("#sharexin").on("click",function(){
    $(this).socialShare("sinaWeibo");
})
$("#shareten").on("click",function(){
    $(this).socialShare("tQQ");
})
$("#sharedou").on("click",function(){
    $(this).socialShare("doubanShare");
})
$("#sharewei").on("click",function(){
    $(this).socialShare("weixinShare");
})

// 选项卡
Click($(".tit"));
function Click(event){
	var last = 0;
	event.each(function(index){
		$(this).click(function(){
			event.eq(last).removeClass("spe");
			$(this).addClass("spe");
			$(".tab").eq(last).css("display","none");
			$(".tab").eq(index).css("display","block");
			last = index;
		})
	})
}

// 对比栏
$(".compare").click(function(){
	$(".comparebox").css("display","block");
})
$(".lab").click(function(){
	$(".cop")[0].checked = !($(".cop")[0].checked);
	if($(".cop")[0].checked == true){
		var copHtml = "";
		copHtml += `<div class="cpbox_one1">
						<a class="cpboxpic fl" href="">
							<img src="../img/goodsDetailsimg/goods.jpg" alt="">
						</a>
						<div class="cpboxword fr">
						<p>
							<a href="" class="goodsname"></a>
				        </p>
				        <b>￥<span class="price"></span></b>
				        <a href="">删除</a>
				        </div>
				    </div>`;
		$(".cpboxgoods li")[0].innerHTML = copHtml;
	}else{
		$(".cpbox_one1").remove();
	}
})

$(".hiddenbtn").click(function(){
	$(".comparebox").css("display","none");
})

// 播放视频
$(".startbtn").click(function(){
	$(".startbtn").remove();
	$(".gdvideo").append("<video class='videostart' controls='controls' autoplay='autoplay'><source src='../video/AysShop.mp4' type='video/mp4'><p class='errorplay'>此播放器不兼容您当前浏览器，请升级您的浏览器。</p>");
})

// 导航栏信息
$.ajax({
	url:'http://10.80.13.43:8080/classify/findByThirdId.do',
	type:'post',
	dataType:'json',
	data:{classifyId:100},
	success:function(data){
		console.log(data);
		$(".gdname_one").text(data[0].classifyName);
		$(".gdname_two").text(data[1].classifyName);
		$(".gdname_three").text(data[2].classifyName);
	}
})

// 请求商品信息
$.ajax({
	url:'http://10.80.13.43:8080/goods/findGoodsByGoodsId.do',
	type:'post',
	dataType:'json',
	data:{goodsId:20},
	success:function(data){
		console.log(data);
		$(".goodsname").text(data.goodsName);
		$(".pricedel").text(data.goodsConsultPrice);
		$(".price").text(data.goodsMemberPrice);
		$(".refnum").text(data.goodsNum);
		$(".activity").text(data.goodsSalesMes);
		$(".savenum").text(data.goodsInventory);
	}
})

// 商品尺寸信息
$.ajax({
	url:'http://10.80.13.43:8080/sizeInfo/findSizeInfoByGoodsId',
	type:'post',
	dataType:'json',
	data:{goodsId:4},
	success:function(data){
		console.log(data);
		$(".size").text(data[0].context + " : ");
		var sizeHtml = "";
		for(i in data){
			sizeHtml += `<li class="s_goods">
							<a><span>${data[i].sizeName}</span></a>
						</li>`;
		}
		$(".s ul").html(sizeHtml);
		goodsClick($(".s_goods"));
	}
})

// 商品规格信息
$(".gdrk").click(function(){
	$.ajax({
		url:'http://10.80.13.43:8080/goods/findConditionsByGoodsId.do',
		type:'post',
		dataType:'json',
		data:{goodsId:4},
		success:function(data){
			console.log(data);
			var rankHtml = "";
			for(i in data){
				rankHtml += `<tr>
								<td class="gdname">${data[i].condition_name} : </td>
								<td class="gdcontnet">${data[i].condition_value}</td>
							</tr>`;
			}
			$(".gdrank table").html(rankHtml);
		}
	})
})





