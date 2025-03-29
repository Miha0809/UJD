import heapq

def heuristic(a, b, method="manhattan"):
    """ Heurystyka Manhattan lub Euklidesowa """
    if method == "manhattan":
        return abs(a[0] - b[0]) + abs(a[1] - b[1])
    elif method == "euclidean":
        return ((a[0] - b[0]) ** 2 + (a[1] - b[1]) ** 2) ** 0.5
    return 0

def reconstruct_path(came_from, current):
    """ Odtworzenie ścieżki z końca do początku """
    path = []
    while current in came_from:
        path.append(current)
        current = came_from[current]
    path.append(current)
    return path[::-1]  

def is_reachable(grid, start, goal):
    """ Sprawdzenie, czy cel jest osiągalny """
    rows, cols = len(grid), len(grid[0])
    queue = [start]
    visited = set()

    while queue:
        x, y = queue.pop(0)
        if (x, y) == goal:
            return True  
        
        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:  
            nx, ny = x + dx, y + dy
            if 0 <= nx < rows and 0 <= ny < cols and grid[nx][ny] == 0 and (nx, ny) not in visited:
                visited.add((nx, ny))
                queue.append((nx, ny))

    return False  

def astar(grid, start, goal, diagonal_movement=False, heuristic_type="manhattan"):
    """ Implementacja algorytmu A* """
    if not is_reachable(grid, start, goal):
        return None  

    rows, cols = len(grid), len(grid[0])
    open_set = []
    heapq.heappush(open_set, (0, start))
    
    came_from = {}
    g_score = {start: 0}
    f_score = {start: heuristic(start, goal, heuristic_type)}


    if diagonal_movement:
        moves = [(-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (1, 1), (-1, 1), (1, -1)]
    else:
        moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    while open_set:
        _, current = heapq.heappop(open_set)

        if current == goal:
            return reconstruct_path(came_from, current)

        for dx, dy in moves:
            neighbor = (current[0] + dx, current[1] + dy)

            if 0 <= neighbor[0] < rows and 0 <= neighbor[1] < cols and grid[neighbor[0]][neighbor[1]] == 0:
                tentative_g_score = g_score[current] + (1.4 if dx != 0 and dy != 0 else 1)

                if neighbor not in g_score or tentative_g_score < g_score[neighbor]:
                    came_from[neighbor] = current
                    g_score[neighbor] = tentative_g_score
                    f_score[neighbor] = tentative_g_score + heuristic(neighbor, goal, heuristic_type)
                    heapq.heappush(open_set, (f_score[neighbor], neighbor))

    return None  


# Zadanie 1: Plansza 4x4
grid_4x4 = [
    [0, 1, 0, 0],
    [0, 1, 0, 1],
    [0, 0, 0, 1],
    [0, 1, 0, 0]
]
start_4x4 = (0, 0)
goal_4x4 = (3, 3)
path_4x4 = astar(grid_4x4, start_4x4, goal_4x4)
print("Zadanie 1 - Najkrótsza ścieżka (4x4):", path_4x4)


# Zadanie 2: Plansza 6x6
grid_6x6 = [
    [0, 0, 1, 0, 0, 0],
    [0, 1, 1, 1, 1, 0],
    [0, 1, 0, 0, 0, 0],
    [0, 1, 1, 1, 0, 1],
    [0, 0, 0, 1, 0, 1],
    [0, 1, 0, 0, 0, 0]
]
start_6x6 = (0, 0)
goal_6x6 = (5, 5)
path_6x6 = astar(grid_6x6, start_6x6, goal_6x6)
print("Zadanie 2 - Najkrótsza ścieżka (6x6):", path_6x6)

# Zadanie 3: Plansza 5x5
grid_5x5_complex = [
    [0, 1, 1, 1, 0],
    [0, 0, 0, 1, 0],
    [1, 1, 0, 1, 0],
    [0, 0, 0, 0, 1],
    [1, 1, 1, 0, 0]
]
start_5x5_complex = (0, 0)
goal_5x5_complex = (4, 4)
path_5x5_complex = astar(grid_5x5_complex, start_5x5_complex, goal_5x5_complex)
print("Zadanie 3 - Najkrótsza ścieżka (5x5):", path_5x5_complex)


# Zadanie 4: Plansza 5x5 (dowolny start i cel)
grid_5x5_var = [
    [0, 0, 1, 0, 0],
    [1, 0, 1, 0, 1],
    [0, 0, 0, 0, 0],
    [1, 1, 0, 1, 0],
    [0, 0, 0, 1, 0]
]
start_5x5_var = (2, 2)
goal_5x5_var = (4, 0)
path_5x5_var = astar(grid_5x5_var, start_5x5_var, goal_5x5_var)
print("Zadanie 4 - Najkrótsza ścieżka (5x5, różne start i cel):", path_5x5_var)


# Zadanie 5: Plansza 7x7
grid_7x7 = [
    [0, 0, 0, 1, 0, 0, 0],
    [1, 1, 0, 1, 1, 1, 0],
    [0, 0, 0, 0, 0, 1, 0],
    [0, 1, 1, 1, 0, 1, 0],
    [0, 1, 0, 0, 0, 1, 0],
    [0, 1, 0, 1, 1, 1, 0],
    [0, 0, 0, 1, 0, 0, 0]
]
start_7x7 = (0, 0)
goal_7x7 = (6, 6)
path_7x7 = astar(grid_7x7, start_7x7, goal_7x7)
print("Zadanie 5 - Najkrótsza ścieżka (7x7):", path_7x7)
