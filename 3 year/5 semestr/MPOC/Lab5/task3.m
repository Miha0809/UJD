clc
close all
clear all

pkg image load

image = imread('moon.tif');
image_gaussian = imnoise(image, 'gaussian', 0, 0.01);
image_salt_pepper = imnoise(image, 'salt & pepper', 0.05);
image_speckle = imnoise(image, 'speckle', 0.05);
image_poisson = imnoise(image, 'poisson');

h3x3 = fspecial('average', [3 3]);
h5x5 = fspecial('average', [5 5]);
h7x7 = fspecial('average', [7 7]);

image_gaussian_3x3 = imfilter(image_gaussian, h3x3);
image_gaussian_5x5 = imfilter(image_gaussian, h5x5);
image_gaussian_7x7 = imfilter(image_gaussian, h7x7);

image_salt_pepper_3x3 = imfilter(image_salt_pepper, h3x3);
image_salt_pepper_5x5 = imfilter(image_salt_pepper, h5x5);
image_salt_pepper_7x7 = imfilter(image_salt_pepper, h7x7);

image_speckle_3x3 = imfilter(image_speckle, h3x3);
image_speckle_5x5 = imfilter(image_speckle, h5x5);
image_speckle_7x7 = imfilter(image_speckle, h7x7);

image_poisson_3x3 = imfilter(image_poisson, h3x3);
image_poisson_5x5 = imfilter(image_poisson, h5x5);
image_poisson_7x7 = imfilter(image_poisson, h7x7);

figure;
subplot(2, 3, 1), imshow(image_gaussian_3x3), title('Gaussian 3x3');
subplot(2, 3, 2), imshow(image_gaussian_5x5), title('Gaussian 5x5');
subplot(2, 3, 3), imshow(image_gaussian_7x7), title('Gaussian 7x7');
subplot(2, 3, 4), imshow(image_salt_pepper_3x3), title('Salt & Pepper 3x3');
subplot(2, 3, 5), imshow(image_salt_pepper_5x5), title('Salt & Pepper 5x5');
subplot(2, 3, 6), imshow(image_salt_pepper_7x7), title('Salt & Pepper 7x7');

h_hp = fspecial('laplacian', 0.2);

image_hp_gaussian = imfilter(image_gaussian, h_hp);
image_hp_salt_pepper = imfilter(image_salt_pepper, h_hp);
image_hp_speckle = imfilter(image_speckle, h_hp);
image_hp_poisson = imfilter(image_poisson, h_hp);

figure;
subplot(2, 2, 1), imshow(image_hp_gaussian), title('HP Gaussian');
subplot(2, 2, 2), imshow(image_hp_salt_pepper), title('HP Salt & Pepper');
subplot(2, 2, 3), imshow(image_hp_speckle), title('HP Speckle');
subplot(2, 2, 4), imshow(image_hp_poisson), title('HP Poisson');

