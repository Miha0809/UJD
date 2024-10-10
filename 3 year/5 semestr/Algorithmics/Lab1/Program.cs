var task1 = new GraphMatrix();
task1.AddEdge(2, 2);
task1.ToString();
Console.WriteLine("\n\n\n");
task1.AddEdge(7, 2);
task1.ToString();
Console.WriteLine("\n\n\n");
task1.RemoveEdge(7, 2);
task1.ToString();

// Task2
var task2 = new GrapthAdjList();

var el1 = new Node();
var el2 = new Node();
var el3 = new Node();
var el4 = new Node();

task2.AddEdge(el1, el2);
task2.AddEdge(el1, el3);
task2.AddEdge(el3, el4);

task2.RemoveEdge(el1, el2);

// Task3
int[,] points2 = new int[,]
{
    { 0, 1 },
    { 0, 2 },
    { 0, 3 },
    { 1, 0 },
    { 2, 1 },
    { 3, 4 },
    { 5, 6 },
};
