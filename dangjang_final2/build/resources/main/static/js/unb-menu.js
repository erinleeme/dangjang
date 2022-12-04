const t_m_cs = document.getElementById('t_m_cs');
const t_m_cs_sub = document.getElementById('t_m_cs_sub');

function overCS(event){
    t_m_cs_sub.style.display = 'block';
}
function outCS(event){
    t_m_cs_sub.style.display = 'none';
}
$(function (){
    t_m_cs.addEventListener("mouseover", overCS);
    t_m_cs.addEventListener("mouseout", outCS);
});




// unb header 개인 메뉴
const t_m_mine = document.getElementById('t_m_mine');
const t_m_mine_sub = document.getElementById('t_m_mine_sub');

function overM(event){
    t_m_mine_sub.style.display = 'block';
}
function outM(event){
    t_m_mine_sub.style.display = 'none';
}
$(function (){
    t_m_mine.addEventListener("mouseover", overM);
    t_m_mine.addEventListener("mouseout", outM);
});
