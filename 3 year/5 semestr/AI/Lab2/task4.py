import random


def target_function(x):
    return x**3 - 4*x**2 + 6*x - 24


def fitness_function(x):
    return abs(target_function(x))


def generate_population(population_size, x_min, x_max):
    return [random.uniform(x_min, x_max) for _ in range(population_size)]


def roulette_wheel_selection(population, fitness_scores):
    total_fitness = sum(fitness_scores)
    if total_fitness == 0:
        return random.choices(population, k=len(population))
    probabilities = [fitness / total_fitness for fitness in fitness_scores]
    return random.choices(population, weights=probabilities, k=len(population))


def crossover(parent1, parent2):
    alpha = random.random()
    offspring1 = alpha * parent1 + (1 - alpha) * parent2
    offspring2 = alpha * parent2 + (1 - alpha) * parent1
    return offspring1, offspring2


def mutation(value, mutation_prob, x_min, x_max):
    if random.random() < mutation_prob:
        mutation_amount = random.uniform(-1, 1) * 0.1 * (x_max - x_min)
        return min(max(value + mutation_amount, x_min), x_max)
    return value


def genetic_algorithm(population_size, generations, mutation_prob, x_min, x_max):
    population = generate_population(population_size, x_min, x_max)
    for generation in range(generations):
        fitness_scores = [1 / (1 + fitness_function(x))
                          for x in population]
        new_population = []
        selected_population = roulette_wheel_selection(
            population, fitness_scores)
        for i in range(0, population_size, 2):
            parent1, parent2 = selected_population[i], selected_population[i + 1]
            offspring1, offspring2 = crossover(parent1, parent2)
            new_population.extend([offspring1, offspring2])
        population = [mutation(individual, mutation_prob, x_min, x_max)
                      for individual in new_population]
        best_individual = min(population, key=fitness_function)
        best_fitness = fitness_function(best_individual)
        print(f"Generation {generation + 1}: Best x = {best_individual}, f(x) = {
              target_function(best_individual)}, Fitness = {best_fitness}")
        if best_fitness < 1e-6:
            print("Solution found close to zero.")
            break
    best_individual = min(population, key=fitness_function)
    best_fitness = fitness_function(best_individual)
    print(f"Best solution: x = {best_individual}, f(x) = {
          target_function(best_individual)}, Fitness = {best_fitness}")


population_size = 20
generations = 50
mutation_prob = 0.1
x_min, x_max = -10, 10
genetic_algorithm(population_size, generations, mutation_prob, x_min, x_max)
