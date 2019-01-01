
document.getElementById("btn").onclick = function () {
    // 获取img元素
    // 为了让浏览器发送请求到servlet, 所以一定要改变src
    document.getElementsByTagName("img")[0].src = "verifycode?time=" + new Date().getTime();
};