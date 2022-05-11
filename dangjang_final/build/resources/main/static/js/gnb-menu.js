// 전체 메뉴 보기
// $('.menu0').mouseover(function(){
//     $('#gnb_allCat').attr('style', 'display: block');
//     $('.gnb_sub_menu').hover(function(){
//         $('#gnb_allCat').attr('style', 'display: block');
//         $('#gnb_allCat').attr('style', 'width: 470px');
//         $('.gnb_sub_menu').next().addClass('.current');
//     })
// });

const menu0 = document.querySelector('.menu0');
const gnbAllCat = document.querySelector('#gnb_allCat');
function overMenu0(event){
    $('#gnb_allCat').css('display', 'block');
}
function outMenu0(event){
    $('#gnb_allCat').css('display', 'none');
}
menu0.addEventListener("mouseover", overMenu0);
menu0.addEventListener("mouseout", outMenu0);


// 스크롤 시 gnb 메뉴 고정
const topMenu = document.getElementById('headerGnbWrap');
let topMenuPosition = topMenu.offsetTop;
$(function(){
    $(window).scroll(function(){
        if($(this).scrollTop() > topMenuPosition){
            topMenu.classList.add('sticky');
            document.querySelector('.gnb_search_section').classList.add('sticky_02');
            $('#gnb_allCat').attr('top', '55px');
        } else {
            topMenu.classList.remove('sticky');
            document.querySelector('.gnb_search_section').classList.remove('sticky_02');
            $('#gnb_allCat').attr('top', '50px');
        }
    })
});

// 상품 검색창 오픈
const ico_search = document.getElementById('ico_search');
const ico_close = document.getElementById('ico_close');
const gnb_search_section = document.querySelector('.gnb_search_section');

function ico_search_click(){
    if(ico_search.getAttribute('display') != 'none'){
        ico_search.setAttribute('style', 'display: none');
        ico_close.setAttribute('style', 'display: inline-block');
        gnb_search_section.setAttribute('style', 'display: block');
    }
}
function ico_close_click(){
    if(ico_close.getAttribute('display') != 'none'){
        ico_search.setAttribute('style', 'display: block');
        ico_close.setAttribute('style', 'display: none');
        gnb_search_section.setAttribute('style', 'display: none');
    }
}
ico_search.addEventListener('click', ico_search_click);
ico_close.addEventListener('click', ico_close_click);


// 상품 검색
$('#btn_search').click(function(){
    if($('#search_word').val() == ''){
        $('#search_word').focus();
    } else {
        location.href='/dangjang/shop/search?keyword='+$('#search_word').val();
    };
});

// 카테고리 리스트 보여주기
const gnb_allCat = document.querySelector('#gnb_allCat');
function overGnb(event){
    $('#gnb_allCat').css('display', 'block');
}
function outGnb(event){
    $('#gnb_allCat').css('display', 'none');
}
gnb_allCat.addEventListener("mouseover", overGnb);
gnb_allCat.addEventListener("mouseout", outGnb);

// 카테고리 이동 함수
function showCategory(element){
    let categoryCode = $(element).attr('data-cat');

    location.href='/dangjang/shop/goods/category?categoryCode='+categoryCode;
}

function noteCategory(element){
    $(element).parent().css('border', '1px solid #00ACC1');
}
function removeNoteCategory(element){
    $(element).parent().css('border', 'none');
}



