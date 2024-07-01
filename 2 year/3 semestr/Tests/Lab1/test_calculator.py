import unittest
import calculator


class Test(unittest.TestCase):
    def test_add_1(self):
        self.assertTrue(calculator.add(1, 4), 5)

    def test_add_2(self):
        self.assertTrue(calculator.add(82, -14), 69)

    def test_sub(self):
        raise NotImplementedError()