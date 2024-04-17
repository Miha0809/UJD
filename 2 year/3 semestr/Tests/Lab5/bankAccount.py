import asyncio

class BankAccount:

    def __init__(self):
        self.balance = 0
        self.transactions = []

    async def deposit(self, amount):
        await asyncio.sleep(1)
        self.balance += amount
        self.transactions.append(f"Deposit: ${amount}")

    async def withdraw(self, amount):
        await asyncio.sleep(1)
        if amount <= self.balance:
            self.balance -= amount
            self.transactions.append(f"Withdrawal: ${amount}")
        else:
            raise ValueError("Insufficient funds")

    async def transfer(self, amount, recipient):
        await asyncio.gather(
            self.withdraw(amount),
            recipient.deposit(amount)
        )

    async def history(self):
        await asyncio.sleep(1)
        return self.transactions

    def get_balance(self):
        return self.balance
