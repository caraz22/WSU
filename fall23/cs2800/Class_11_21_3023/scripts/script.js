// save images in an array
const myImages = ['images/img1.jpg', 
                    'images/img2.jpg' , 
                    'images/img3.jpg' , 
                    'images/img4.jpg'    
                    // add more images  
                ];
// initialize the display with the first image
let currentIndex = 0;
displayImage(currentIndex);
// function to display the current image
function displayImage(index)
{// start bracket
    const ImageContainer = document.getElementById('imageContainer');
    const imageUrl = myImages[index]; 
    ImageContainer.innerHTML = `<img src="${imageUrl}"  
                                 alt="Image ${index + 1}">`;
}// end bracket

// function to handle displaying the rest of the images per clicking

function nextImage()
{
    currentIndex = (currentIndex + 1) % myImages.length;
    displayImage(currentIndex);
}
 
// add click event 
   const NextLink      = document.getElementById('nextLink');
   NextLink.addEventListener( 'click' , nextImage );

