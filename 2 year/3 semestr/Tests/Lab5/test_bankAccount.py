import unittest
import asyncio
from bankAccount import BankAccount

class TestBankAccount(unittest.TestCase):

    def setUp(self):
        self.account = BankAccount()

    def test_deposit(self):
        asyncio.run(self.account.deposit(100))
        self.assertEqual(self.account.get_balance(), 100)

    def test_withdraw(self):
        asyncio.run(self.account.deposit(100))
        asyncio.run(self.account.withdraw(50))
        self.assertEqual(self.account.get_balance(), 50)

    def test_transfer(self):
        sender = BankAccount()
        receiver = BankAccount()

        asyncio.run(sender.deposit(100))
        asyncio.run(sender.transfer(50, receiver))

        self.assertEqual(sender.get_balance(), 50)
        self.assertEqual(receiver.get_balance(), 50)

    def test_history(self):
        asyncio.run(self.account.deposit(100))
        asyncio.run(self.account.withdraw(50))
        history = asyncio.run(self.account.history())
        
        self.assertEqual(len(history), 2)
        self.assertEqual(history[0], "Deposit: $100")
        self.assertEqual(history[1], "Withdrawal: $50")

if __name__ == '__main__':
    unittest.main()
