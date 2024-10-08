var a = new GraphMatrix2(4);
a.AddEdge(2, 2);
a.AddEdge(2, 3);
a.Display();
Console.WriteLine("\n\n\n");
a.RemoveEdge(2, 3);
a.Display();

Console.WriteLine("\n\n\n");
var task1 = new GraphMatrix();
task1.AddEdge(2, 2);
task1.Display();
Console.WriteLine("\n\n\n");
task1.AddEdge(2, 2);
task1.Display();

// Task1
var points = new bool[7, 7]
{
    { false, true, true, true, false, false, false },
    { true, false, false, false, false, false, false },
    { false, true, false, false, false, false, false },
    { false, false, false, false, true, false, false },
    { false, false, false, false, false, false, false },
    { false, false, false, false, false, false, true },
    { false, false, false, false, false, false, false },
};

// Task2
var el1 = new Node();
var el2 = new Node();

el1.NextItem.Add(el2);

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
