clc
close all
clear all

pkg image load

function img_stretched = stretch_histogram(img)
    if size(img, 3) == 3
        img = rgb2gray(img);
    end

    fmin = double(min(img(:)));
    fmax = double(max(img(:)));
    min_val = 0;
    max_val = 255;
    img_stretched = (double(img) - fmin) / (fmax - fmin) * (max_val - min_val) + min_val;
    img_stretched = uint8(img_stretched);
end

img = imread('office_1.jpg');
img2 = imread('office_6.jpg');

if size(img, 3) == 3
    img = rgb2gray(img);
end

img_eq = histeq(img);
img_stretched = stretch_histogram(img);

figure;
subplot(2, 2, 1), imshow(img), title('Obraz oryginalny');
subplot(2, 2, 2), imshow(img_eq), title('Obraz po wyrównaniu histogramu');
subplot(2, 2, 3), imshow(img_stretched), title('Obraz po rozciągnięciu histogramu');

if size(img2, 3) == 3
    img2 = rgb2gray(img2);
end

img_eq2 = histeq(img2);
img_stretched2 = stretch_histogram(img2);

figure;
subplot(2, 2, 1), imshow(img2), title('Obraz oryginalny');
subplot(2, 2, 2), imshow(img_eq2), title('Obraz po wyrównaniu histogramu');
subplot(2, 2, 3), imshow(img_stretched2), title('Obraz po rozciągnięciu histogramu');
