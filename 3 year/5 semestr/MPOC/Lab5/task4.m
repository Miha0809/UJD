clc
close all
clear all

pkg image load

image = imread('moon.tif');
image_gaussian = imnoise(image, 'gaussian', 0, 0.01);
image_salt_pepper = imnoise(image, 'salt & pepper', 0.05);
image_speckle = imnoise(image, 'speckle', 0.05);
image_poisson = imnoise(image, 'poisson');

image_median_3x3 = medfilt2(image_gaussian, [3 3]);
image_median_5x5 = medfilt2(image_gaussian, [5 5]);
image_median_7x7 = medfilt2(image_gaussian, [7 7]);

image_max_3x3 = nlfilter(image_gaussian, [3 3], @(x) max(x(:)));
image_max_5x5 = nlfilter(image_gaussian, [5 5], @(x) max(x(:)));
image_max_7x7 = nlfilter(image_gaussian, [7 7], @(x) max(x(:)));

image_min_3x3 = nlfilter(image_gaussian, [3 3], @(x) min(x(:)));
image_min_5x5 = nlfilter(image_gaussian, [5 5], @(x) min(x(:)));
image_min_7x7 = nlfilter(image_gaussian, [7 7], @(x) min(x(:)));

h3x3 = fspecial('average', [3 3]);
h5x5 = fspecial('average', [5 5]);
h7x7 = fspecial('average', [7 7]);

image_gaussian_3x3 = imfilter(image_gaussian, h3x3);
image_gaussian_5x5 = imfilter(image_gaussian, h5x5);
image_gaussian_7x7 = imfilter(image_gaussian, h7x7);

figure;
subplot(3, 3, 1), imshow(image_median_3x3), title('Median 3x3');
subplot(3, 3, 2), imshow(image_max_3x3), title('Max 3x3');
subplot(3, 3, 3), imshow(image_min_3x3), title('Min 3x3');
subplot(3, 3, 4), imshow(image_median_5x5), title('Median 5x5');
subplot(3, 3, 5), imshow(image_max_5x5), title('Max 5x5');
subplot(3, 3, 6), imshow(image_min_5x5), title('Min 5x5');
subplot(3, 3, 7), imshow(image_median_7x7), tit

