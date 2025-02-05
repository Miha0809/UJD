import numpy as np
import matplotlib.pyplot as plt

class CreditScoreEvaluator:
    def __init__(self):
        pass

    def evaluate(self, income, credit_history_score):
        if credit_history_score < 50:
            creditworthiness = max(0, min(50, 0.5 * income))
        elif credit_history_score >= 50 and credit_history_score < 80:
            creditworthiness = max(0, min(80, 0.7 * income + 0.3 * credit_history_score))
        else:
            creditworthiness = max(0, min(100, 0.4 * income + 0.6 * credit_history_score))

        return creditworthiness

    def plot_membership_functions(self):
        income_range = np.linspace(0, 10000, 100)
        credit_history_range = np.linspace(0, 100, 100)
        membership_low_income = np.maximum(0, 1 - income_range / 5000)
        membership_high_income = np.maximum(0, (income_range - 5000) / 5000)
        membership_poor_history = np.maximum(0, 1 - credit_history_range / 50)
        membership_good_history = np.maximum(0, np.minimum((credit_history_range - 50) / 30, 1))
        membership_excellent_history = np.maximum(0, (credit_history_range - 80) / 20)

        plt.figure(figsize=(15, 5))
        plt.subplot(1, 2, 1)
        plt.plot(income_range, membership_low_income, label='Low Income')
        plt.plot(income_range, membership_high_income, label='High Income')
        plt.title('Membership Function - Income')
        plt.xlabel('Income (USD)')
        plt.ylabel('Membership')
        plt.legend()
        plt.subplot(1, 2, 2)
        plt.plot(credit_history_range, membership_poor_history, label='Poor Credit History')
        plt.plot(credit_history_range, membership_good_history, label='Good Credit History')
        plt.plot(credit_history_range, membership_excellent_history, label='Excellent Credit History')
        plt.title('Membership Function - Credit History')
        plt.xlabel('Credit History Score')
        plt.ylabel('Membership')
        plt.legend()
        plt.tight_layout()
        plt.show()

if __name__ == "__main__":
    credit_evaluator = CreditScoreEvaluator()
    credit_evaluator.plot_membership_functions()
    income_input = 4000 
    credit_history_input = 65
    creditworthiness_score = credit_evaluator.evaluate(income_input, credit_history_input)

    print(f"Income: ${income_input}")
    print(f"Credit History Score: {credit_history_input}")
    print(f"Creditworthiness Evaluation Score: {creditworthiness_score:.2f}")
