import random

def fitness_function(chromosome):
    x = int(chromosome, 2)  
    return 2 * x + 3  # f(x) = 2x + 3

def generate_population(population_size, chromosome_length):
    return [''.join(random.choice('01') for _ in range(chromosome_length)) for _ in range(population_size)]

def roulette_wheel_selection(population):
    total_fitness = sum(fitness_function(chrom) for chrom in population)
    weights = [fitness_function(chrom) / total_fitness for chrom in population]
    return random.choices(population, weights=weights, k=len(population))

def crossover(chromosome1, chromosome2):
    point = random.randint(1, len(chromosome1) - 1)
    return (chromosome1[:point] + chromosome2[point:], chromosome2[:point] + chromosome1[point:])

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
            parent1, parent2 = population[i], population[i+1]
            offspring1, offspring2 = crossover(parent1, parent2)
            new_population.extend([mutation(offspring1, mutation_prob), mutation(offspring2, mutation_prob)])
        
        population = new_population
        best_chromosome = max(population, key=fitness_function)
        print(f"Generation {generation + 1}: Best = {best_chromosome} (x = {int(best_chromosome, 2)}), f(x) = {fitness_function(best_chromosome)}")

    best_chromosome = max(population, key=fitness_function)
    print(f"Best solution: x = {int(best_chromosome, 2)}, f(x) = {fitness_function(best_chromosome)}")

population_size = 20
chromosome_length = 11  
generations = 15
mutation_prob = 0.001

genetic_algorithm(population_size, chromosome_length, generations, mutation_prob)
