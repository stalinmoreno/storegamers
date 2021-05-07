
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

// slider categorias

// const swiper = new Swiper('.swiper-container', {
//   // Optional parameters
//   direction: 'horizontal',
//   loop: true,

//   // If we need pagination
//   // pagination: {
//   //   el: '.swiper-pagination',
//   // },

//   // Navigation arrows
//   navigation: {
//     nextEl: '.swiper-button-next',
//     prevEl: '.swiper-button-prev',
//   },

//   // And if we need scrollbar
//   // scrollbar: {
//   //   el: '.swiper-scrollbar',
//   // },
// });


var swiper = new Swiper(".mySwiper", {
  slidesPerView: 3,
  spaceBetween: 30,
  pagination: {
    el: ".swiper-pagination",
    clickable: true,
  },
  breakpoints: {
    360: {
      slidesPerView: 3,
      spaceBetween: 10,
    },
    640: {
      slidesPerView: 3,
      spaceBetween: 10,
    },
    768: {
      slidesPerView: 4,
      spaceBetween: 20,
    },
    1024: {
      slidesPerView: 5,
      spaceBetween: 30,
    },
  },
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },
});