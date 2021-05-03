
const btnclose = document.getElementById("btnClose"),
  btnMenu = document.getElementById("btnMenu"),
  divMenu = document.getElementById("menu"),
  divOverlay = document.getElementById("bg-overlay");

btnclose.addEventListener("click", () => {
  divMenu.classList.toggle('hide');
  divOverlay.classList.toggle('hide');
});

btnMenu.addEventListener("click", () => {
  divMenu.classList.remove('hide');
  divOverlay.classList.remove('hide');
});

divOverlay.addEventListener("click", () => {
  divMenu.classList.toggle('hide');
  divOverlay.classList.toggle('hide');
});
