clc
close all
clear all
pkg load image

image = imread('Obraz_03a.png');

if size(image, 3) == 3
        imagegray = rgb2gray(image);
    else
        imagegray = image;
    end
imaged = double(imagegray);

window = 5;
half_w = floor(window / 2);

kernel = ones(window, window) / (window^2);
mean1 = imfilter(imaged, kernel, 'replicate');
mean2 = imfilter(imaged, flip(kernel, 2), 'replicate');
mean3 = imfilter(imaged, flip(kernel, 1), 'replicate');
mean4 = imfilter(imaged, rot90(kernel, 2), 'replicate');
var1 = imfilter(imaged.^2, kernel, 'replicate') - mean1.^2;
var2 = imfilter(imaged.^2, flip(kernel, 2), 'replicate') - mean2.^2;
var3 = imfilter(imaged.^2, flip(kernel, 1), 'replicate') - mean3.^2;
var4 = imfilter(imaged.^2, rot90(kernel, 2), 'replicate') - mean4.^2;

all_means = cat(3, mean1, mean2, mean3, mean4);
all_vars = cat(3, var1, var2, var3, var4);
[~, min_idx] = min(all_vars, [], 3);
rezult = zeros(size(imaged));

for i = 1:size(imaged,1)
    for j = 1:size(imaged,2)
        rezult(i, j) = all_means(i, j, min_idx(i, j));
    end
end
rezult = uint8(rezult);

figure
subplot(1,2,1), imshow(imagegray), title('Obraz_03a szaroś');
subplot(1,2,2), imshow(rezult), title('Obraz_03a Kuwahary');

imwrite(rezult,'Obraz_03a_kuwahary.png')
