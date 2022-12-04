// 상단 이벤트 배너 클릭 이벤트
const tpbOpen = document.getElementById('tpbOpen');
const tpbClose = document.getElementById('tpbClose');

tpbOpen.addEventListener("click", function open(event){
    document.getElementById('tpbInner').style.display = 'none';
    tpbOpen.style.display = 'none';
    document.getElementById('tpbInner_Open').style.display = 'flex';
})

tpbClose.addEventListener("click", function(event){
    document.getElementById('tpbInner').style.display = "flex";
    tpbOpen.style.display = 'block';
    document.getElementById('tpbInner_Open').style.display = 'none';
})

