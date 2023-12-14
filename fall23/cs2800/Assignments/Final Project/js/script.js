var $ = function(id) {
    return document.getElementById(id);
}

var arrayIndex = 0;

function changeImage() {
    var currentImage = $("image");
    var imagePaths = ["images/img1.jpg", "images/img2.jpg", "images/img3.jpg", "images/img4.jpg", "images/img5.jpg"];
    if (arrayIndex < 4) {
        arrayIndex++;
    } else {
        arrayIndex = 0;
    }
    currentImage.src = imagePaths[arrayIndex];
}