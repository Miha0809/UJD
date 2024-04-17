from unittest import TestCase

import main


class Test(TestCase):
    def test_max(self):
        self.assertEquals(main._max(1, 2), 2)

    def test_min(self):
        self.assertEquals(main._min(1, 2, 3), 1)

    def test_sign_1(self):
        self.assertEquals(main.sign(25), 1)

    def test_sign_2(self):
        self.assertEquals(main.sign(0), 0)

    def test_sign_3(self):
        self.assertEquals(main.sign(-25), -1)

    def test_avg(self):
        self.assertEquals(main.avg(1, 2, 3), 2)

    def test_median(self):
        self.assertEquals(main.median(1, 2, 3, 4, 5), 3)
