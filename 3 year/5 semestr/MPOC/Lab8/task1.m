clc
close all
clear all

pkg load image;

img_bmp1 = imread('one.bmp');
img_bmp2 = imread('two.bmp');
img_jpg1 = imread('one.jpg');
img_jpg2 = imread('two.jpg');

if size(img_bmp1, 3) == 3
  img_bmp1_gray = rgb2gray(img_bmp1);
else
  img_bmp1_gray = img_bmp1;
end

if size(img_bmp2, 3) == 3
  img_bmp2_gray = rgb2gray(img_bmp2);
else
  img_bmp2_gray = img_bmp2;
end

if size(img_jpg1, 3) == 3
  img_jpg1_gray = rgb2gray(img_jpg1);
else
  img_jpg1_gray = img_jpg1;
end

if size(img_bmp1, 3) == 3
  img_jpg2_gray = rgb2gray(img_jpg2);
else
  img_jpg2_gray = img_jpg2;
end


edges_sobel_bmp1 = edge(img_bmp1_gray, 'Sobel');
edges_prewitt_bmp1 = edge(img_bmp1_gray, 'Prewitt');
edges_canny_bmp1 = edge(img_bmp1_gray, 'Canny');
edges_roberts_bmp1 = edge(img_bmp1_gray, 'Roberts');

edges_sobel_bmp2 = edge(img_bmp2_gray, 'Sobel');
edges_prewitt_bmp2 = edge(img_bmp2_gray, 'Prewitt');
edges_canny_bmp2 = edge(img_bmp2_gray, 'Canny');
edges_roberts_bmp2 = edge(img_bmp2_gray, 'Roberts');

edges_sobel_jpg1 = edge(img_jpg1_gray, 'Sobel');
edges_prewitt_jpg1 = edge(img_jpg1_gray, 'Prewitt');
edges_canny_jpg1 = edge(img_jpg1_gray, 'Canny');
edges_roberts_jpg1 = edge(img_jpg1_gray, 'Roberts');

edges_sobel_jpg2 = edge(img_jpg2_gray, 'Sobel');
edges_prewitt_jpg2 = edge(img_jpg2_gray, 'Prewitt');
edges_canny_jpg2 = edge(img_jpg2_gray, 'Canny');
edges_roberts_jpg2 = edge(img_jpg2_gray, 'Roberts');

figure;
subplot(4, 4, 1);
imshow(edges_sobel_bmp1);
title('Sobel BMP1');

subplot(4, 4, 2);
imshow(edges_prewitt_bmp1);
title('Prewitt BMP1');

subplot(4, 4, 3);
imshow(edges_canny_bmp1);
title('Canny BMP1');

subplot(4, 4, 4);
imshow(edges_roberts_bmp1);
title('Roberts BMP1');

subplot(4, 4, 5);
imshow(edges_sobel_bmp2);
title('Sobel BMP2');

subplot(4, 4, 6);
imshow(edges_prewitt_bmp2);
title('Prewitt BMP2');

subplot(4, 4, 7);
imshow(edges_canny_bmp2);
title('Canny BMP2');

subplot(4, 4, 8);
imshow(edges_roberts_bmp2);
title('Roberts BMP2');

subplot(4, 4, 9);
imshow(edges_sobel_jpg1);
title('Sobel JPG1');

subplot(4, 4, 10);
imshow(edges_prewitt_jpg1);
title('Prewitt JPG1');

subplot(4, 4, 11);
imshow(edges_canny_jpg1);
title('Canny JPG1');

subplot(4, 4, 12);
imshow(edges_roberts_jpg1);
title('Roberts JPG1');

subplot(4, 4, 13);
imshow(edges_sobel_jpg2);
title('Sobel JPG2');

subplot(4, 4, 14);
imshow(edges_prewitt_jpg2);
title('Prewitt JPG2');

subplot(4, 4, 15);
imshow(edges_canny_jpg2);
title('Canny JPG2');

subplot(4, 4, 16);
imshow(edges_roberts_jpg2);
title('Roberts JPG2');

