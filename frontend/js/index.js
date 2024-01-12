let listProductHtml = document.querySelector('.main-pro');
let listProducts = [];
let listProductHtml2 = document.querySelector('.cart');
document.addEventListener("DOMContentLoaded", function () {
    const BASE_URL = "http://localhost:8080/api/v1/products";

    fetch(`${BASE_URL}?page=0&size=10`)
        .then(response => response.json())
        .then(data => {
            const products = data.content || [];

            const productList = document.getElementById("img-item");

            listProductHtml.innerHTML = '';
            products.forEach(product => {
                const listItem = document.createElement("div");
                listItem.classList.add('img-item');
                listItem.innerHTML = `
                <img src="${product.img}" alt="">
                <h2>${product.name}</h2>
                <div class="price">${product.price}</div>
                <button class="addCart">Mua ngay</button>
                `;
                listProductHtml.appendChild(listItem);
            });
        })
        .catch(error => console.error("Error fetching products:", error));
});

document.getElementById("searchForm").addEventListener("submit", function(event) {
    event.preventDefault();
    var productName = document.getElementById("searchInput").value.toLowerCase();

    fetch(`http://localhost:8080/api/v1/products?search=${productName}`)
        .then(response => response.json())
        .then(data => {
            const searchedProducts = data.content || [];

            // Hide all products
            listProductHtml.innerHTML = '';

            // Check if there are searched products
            if (searchedProducts.length > 0) {
                // Loop through each searched product
                searchedProducts.forEach(product => {
                    const listItem = document.createElement("div");
                    listItem.classList.add('img-item');
                    listItem.innerHTML = `
                        <img src="${product.img}" alt="">
                        <h2>${product.name}</h2>
                        <div class="price">${product.price}</div>
                        <button class="addCart">Mua ngay</button>
                    `;
                    listProductHtml.appendChild(listItem);
                });
            } else {
                // Display a message when no products are found
                listProductHtml.innerHTML = '<p>Không tìm thấy sản phẩm.</p>';
            }
        })
        .catch(error => {
            console.error('Error fetching products:', error);
        });
});


function showCart(){
    document.getElementById('cart').style.display = 'block';
    document.getElementById('icon-cart').style.display = 'none';
    showProToCart();
}

function hideCart(){
    document.getElementById('cart').style.display = 'none';
    document.getElementById('icon-cart').style.display = 'block';
}

// function showProToCart(){
//     let listPro = document.querySelector('.img-item');
//     let imgSrc = listPro.querySelector('img').src;
//     let productName = listPro.querySelector('h2').innerText;
//     let productPrice = listPro.querySelector('.price').innerText;
//     console.log(listPro);
//     let lisstPro = document.getElementById('listCard');
//     lisstPro.innerHTML = `
//     <img src="${imgSrc}" alt="" height = 50px>
//     <h2>${productName}</h2>
//     <div class="price">${productPrice}</div>
//     <span>-</span>
//     <span>1</span>
//     <span>+</span>
// `;;
// }

document.addEventListener("DOMContentLoaded", function () {
    // Lấy danh sách tất cả các phần tử có class 'img-item'
    let productList = document.querySelector('.img-item');

    // Duyệt qua từng phần tử và thêm sự kiện click
    productList.forEach(function (product) {
        product.addEventListener('click', function () {
            // Lấy thông tin sản phẩm từ phần tử được click
            let imgSrc = product.querySelector('img').src;
            let productName = product.querySelector('h2').innerText;
            let productPrice = product.querySelector('.price').innerText;
            let lisstPro = document.getElementById('listCard');
            lisstPro.innerHTML = `
            <img src="${imgSrc}" alt="" height = 50px>
            <h2>${productName}</h2>
            <div class="price">${productPrice}</div>
            <span>-</span>
            <span>1</span>
            <span>+</span>
        `;;
           
        });
    });
});

function showProToCart(imgSrc, productName, productPrice) {
    // Lấy phần tử #listCard
    let listCard = document.getElementById('listCard');

    // Tạo một phần tử mới để hiển thị thông tin sản phẩm
    let listItem = document.createElement('div');
    listItem.innerHTML = `
        <img src="${imgSrc}" alt="" height="50px">
        <h2>${productName}</h2>
        <div class="price">${productPrice}</div>
        <span>-</span>
        <span>1</span>
        <span>+</span>
    `;

    // Thêm phần tử mới vào #listCard
    listCard.appendChild(listItem);
}
