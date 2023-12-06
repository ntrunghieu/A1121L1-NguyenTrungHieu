(function($) {
    "use strict";
	
     $(document).on('ready', function() {	
		
		/*====================================
			Mobile Menu
		======================================*/ 	
		$('.menu').slicknav({
			prependTo:".mobile-nav",
			duration:300,
			animateIn: 'fadeIn',
			animateOut: 'fadeOut',
			closeOnClick:true,
		});
		
		/*====================================
		03. Sticky Header JS
		======================================*/ 
		jQuery(window).on('scroll', function() {
			if ($(this).scrollTop() > 200) {
				$('.header').addClass("sticky");
			} else {
				$('.header').removeClass("sticky");
			}
		});
		
		/*=======================
		  Search JS JS
		=========================*/ 
		$('.top-search a').on( "click", function(){
			$('.search-top').toggleClass('active');
		});
		
		
		
		
		
		/*=======================
		  Popular Slider JS
		=========================*/ 
		$('.popular-slider').owlCarousel({
			items:1,
			autoplay:true,
			autoplayTimeout:5000,
			smartSpeed: 400,
			animateIn: 'fadeIn',
			animateOut: 'fadeOut',
			autoplayHoverPause:true,
			loop:true,
			nav:true,
			merge:true,
			dots:false,
			navText: ['<i class="ti-angle-left"></i>', '<i class="ti-angle-right"></i>'],
			responsive:{
				0: {
					items:1,
				},
				300: {
					items:1,
				},
				480: {
					items:2,
				},
				768: {
					items:3,
				},
				1170: {
					items:4,
				},
			}
		});
		
		/*===========================
		  Quick View Slider JS
		=============================*/ 
		$('.quickview-slider-active').owlCarousel({
			items:1,
			autoplay:true,
			autoplayTimeout:5000,
			smartSpeed: 400,
			autoplayHoverPause:true,
			nav:true,
			loop:true,
			merge:true,
			dots:false,
			navText: ['<i class=" ti-arrow-left"></i>', '<i class=" ti-arrow-right"></i>'],
		});
		
		
		
		
		
	
		
		
		/*=======================
		  Extra Scroll JS
		=========================*/
		$('.scroll').on("click", function (e) {
			var anchor = $(this);
				$('html, body').stop().animate({
					scrollTop: $(anchor.attr('href')).offset().top - 0
				}, 900);
			e.preventDefault();
		});
		
		
		
		
		
	
		
		/*====================================
			Scroll Up JS
		======================================*/
		$.scrollUp({
			scrollText: '<span><i class="fa fa-angle-up"></i></span>',
			easingType: 'easeInOutExpo',
			scrollSpeed: 900,
			animation: 'fade'
		});  
		
	});
	
	
		
	
	/*=====================================
	  Preloader JS
	======================================*/ 	
	//After 2s preloader is fadeOut

	setTimeout(function() {
		$('.preloader').delay(2000).fadeOut('slow');
		
	/*====================================
		Flex Slider JS
		======================================*/
		$('.flexslider-thumbnails').flexslider({
			animation: "slide",
			controlNav: "thumbnails",
		});
		/*====================================
	18. Nice Select JS
	======================================*/	
	$('select').niceSelect();
	$('.btn-number').click(function(e) {
		
		e.preventDefault();
	
		var fieldName = $(this).attr('data-field');
		var type = $(this).attr('data-type');
		var input = $("input[name='" + fieldName + "']");
		
		var currentVal = parseFloat(input.val());
		if (!isNaN(currentVal)) {
		  if (type == 'minus') {
	
			if (currentVal > input.attr('data-min')) {
			  input.val(currentVal - 1).change();
			}
			if (parseFloat(input.val()) == input.attr('data-min')) {
			  $(this).attr('disabled', true);
			}
	
		  } else if (type == 'plus') {
	//alert(input.attr('data-max'));
			if (currentVal < input.attr('data-max')) {
			  input.val(currentVal + 1).change();
			}
			if (parseFloat(input.val()) == input.attr('data-max')) {
			  $(this).attr('disabled', true);
			}
	
		  }
		} else {
		  input.val(0);
		}
	  });
	  $('.input-number').focusin(function() {
		$(this).data('oldValue', $(this).val());
	  });
	  $('.input-number').change(function() {
	
		var minValue = parseFloat($(this).attr('data-min'));
		var maxValue = parseFloat($(this).attr('data-max'));
		var valueCurrent = parseFloat($(this).val());
	
		name = $(this).attr('name');
		if (valueCurrent >= minValue) {
		  $(".btn-number[data-type='minus'][data-field='" + name + "']").removeAttr('disabled')
		} else {
		  alert('Sorry, the minimum value was reached');
		  $(this).val($(this).data('oldValue'));
		}
		if (valueCurrent <= maxValue) {
		  $(".btn-number[data-type='plus'][data-field='" + name + "']").removeAttr('disabled')
		} else {
		  alert('Sorry, the maximum value was reached');
		  $(this).val($(this).data('oldValue'));
		}
	
	
	  });
	//After 2s, the no-scroll class of the body will be removed
	   $('body').removeClass('no-scroll');
	}, 2000); //Here you can change preloader time

})(jQuery);
