using Lab1.Interfaces;

Console.WriteLine("\t\t\t\tTask1");
IItemManager<int> task1 = new GraphMatrix();
task1.AddEdge(2, 2);
task1.ToString();
Console.WriteLine("\n\n\n");
task1.AddEdge(7, 2);
task1.ToString();
Console.WriteLine("\n\n\n");
task1.RemoveEdge(7, 2);
task1.ToString();

// Task2
Console.WriteLine("\t\t\t\tTask2");
IItemManager<Node> task2 = new GrapthAdjList();

var el1 = new Node(1);
var el2 = new Node(2);
var el3 = new Node(3);
var el4 = new Node(4);

task2.AddEdge(el1, el2);
task2.AddEdge(el1, el3);
task2.AddEdge(el3, el4);
task2.ToString();

task2.RemoveEdge(el1, el2);

// Task3
Console.WriteLine("\t\t\t\tTask3");
IItemManager<int> task3 = new GraphEdgeList();

task3.AddEdge(0, 1);
task3.AddEdge(0, 2);
task3.AddEdge(0, 3);
task3.AddEdge(1, 0);
task3.AddEdge(2, 1);
task3.AddEdge(3, 4);
task3.AddEdge(5, 6);
task3.ToString();
Console.WriteLine("\n\n\nREMOVE");

task3.RemoveEdge(0, 1);
task3.RemoveEdge(2, 1);
task3.ToString();
Console.WriteLine("\n\n\n");