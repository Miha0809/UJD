import random

items = [
    {"weight": 2, "value": 3},
    {"weight": 3, "value": 4},
    {"weight": 4, "value": 5},
    {"weight": 5, "value": 8},
    {"weight": 9, "value": 10}
]
max_weight = 15


def fitness_function(chromosome):
    total_weight = 0
    total_value = 0
    for i, gene in enumerate(chromosome):
        if gene == '1':
            total_weight += items[i]["weight"]
            total_value += items[i]["value"]
    if total_weight > max_weight:
        return 0
    return total_value


def generate_population(population_size, chromosome_length):
    population = []
    for _ in range(population_size):
        chromosome = ''.join(random.choice('01')
                             for _ in range(chromosome_length))
        population.append(chromosome)
    return population


def roulette_wheel_selection(population):
    total_fitness = sum(fitness_function(chrom) for chrom in population)
    if total_fitness == 0:
        return random.choices(population, k=len(population))
    weights = [fitness_function(chrom) / total_fitness for chrom in population]
    return random.choices(population, weights=weights, k=len(population))


def crossover(chromosome1, chromosome2):
    point = random.randint(1, len(chromosome1) - 1)
    offspring1 = chromosome1[:point] + chromosome2[point:]
    offspring2 = chromosome2[:point] + chromosome1[point:]
    return offspring1, offspring2


def mutation(chromosome, mutation_prob):
    chromosome = list(chromosome)
    for i in range(len(chromosome)):
        if random.random() < mutation_prob:
            chromosome[i] = '1' if chromosome[i] == '0' else '0'
    return ''.join(chromosome)


def genetic_algorithm(population_size, chromosome_length, generations, mutation_prob):
    population = generate_population(population_size, chromosome_length)

    for generation in range(generations):
        population = roulette_wheel_selection(population)
        new_population = []

        for i in range(0, population_size, 2):
            parent1, parent2 = population[i], population[i + 1]
            offspring1, offspring2 = crossover(parent1, parent2)
            new_population.extend([
                mutation(offspring1, mutation_prob),
                mutation(offspring2, mutation_prob)
            ])

        population = new_population
        best_chromosome = max(population, key=fitness_function)
        best_value = fitness_function(best_chromosome)
        print(f"Generation {
              generation + 1}: Best Value = {best_value}, Chromosome = {best_chromosome}")

    best_chromosome = max(population, key=fitness_function)
    best_value = fitness_function(best_chromosome)
    selected_items = [i for i, gene in enumerate(
        best_chromosome) if gene == '1']
    print(f"Best solution: Value = {best_value}, Items = {selected_items}")


population_size = 10
chromosome_length = len(items)
generations = 10
mutation_prob = 0.01

genetic_algorithm(population_size, chromosome_length,
                  generations, mutation_prob)
