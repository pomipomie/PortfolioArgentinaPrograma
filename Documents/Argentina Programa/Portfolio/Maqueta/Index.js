function openNav() {
    document.getElementById("mySidenav").style.width = "30%";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}

const btn = document.querySelector(".btn-toggle");
btn.addEventListener("click", function() {
    document.body.classList.toggle("dark-theme");
});

var modal = document.getElementById('id01');

window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}