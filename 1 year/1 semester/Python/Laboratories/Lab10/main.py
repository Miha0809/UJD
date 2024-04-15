import random
import turtle

#Zad. 1
# drawing_area = turtle.Screen()
# drawing_area.setup(width=750, height=500)

# turtle.shape('turtle')
# turtle.color("blue")
# turtle.Screen().bgcolor("lightgreen")
# turtle.width(2)

# def draw_square(linecolor):
#     for i in range(4):
#         turtle.forward(100)
#         turtle.right(90)
# #square 1
# turtle.right(-90)
# turtle.penup()
# turtle.forward(50)
# turtle.right(-90)
# turtle.forward(200)
# turtle.pendown()
# draw_square('blue')
# #square 2
# turtle.right(180)
# turtle.penup()
# turtle.forward(100)
# turtle.right(-90)
# turtle.pendown()
# draw_square('blue')
# #square 3
# turtle.right(90)
# turtle.penup()
# turtle.forward(200)
# turtle.right(-90)
# turtle.pendown()
# draw_square('blue')
# #square 4
# turtle.right(90)
# turtle.penup()
# turtle.forward(200)
# turtle.right(-90)
# turtle.pendown()
# draw_square('blue')
# #square5
# turtle.right(90)
# turtle.penup()
# turtle.forward(200)
# turtle.right(-90)
# turtle.pendown()
# draw_square('blue')
# #square 6
# turtle.right(90)
# turtle.penup()
# turtle.forward(200)
# turtle.right(-90)
# turtle.pendown()
# draw_square('blue')

# turtle.done()

#Zad. 2
# hypo = (2 ** 0.5) / 2

# screen = turtle.Screen()
# screen.bgcolor("lightgreen")

# tess = turtle.Turtle()
# tess.pencolor("blue")
# tess.shape("turtle")
# tess.setheading(45)
# tess.width(3)

# for radius in range(20, 20 * 5 + 1, 20):
#     tess.penup()
#     tess.goto(radius/2, -radius/2)
#     tess.pendown()
#     tess.circle(radius * hypo, steps=4)
# screen.exitonclick()

#Zad. 3
# sc = turtle.Screen()
# sc.bgcolor("lightgreen")

# t = turtle.Turtle()
# t.shape("turtle")
# t.pencolor("blue")
# t.pensize(2)

# def draw_polygon(t, n, length):
#   for i in range(n):
#     t.forward(length)
#     t.left(360 / n)

# draw_polygon(t, 8, 20)
# turtle.done()

#Zad. 4
# window = turtle.Screen()
# window.bgcolor("lightgreen")

# tur = turtle.Turtle()
# tur.fillcolor('blue') 
# tur.pencolor('blue')
# tur.pensize(3)
# tur.shape("turtle")

# def drawsq(t, s):
#     for i in range(4):
#         t.forward(s)
#         t.left(90)
# for _ in range(20):   
#     tur.left(18)  
#     drawsq(tur, 50)

# turtle.done()

#Zad. 5
# window = turtle.Screen()
# window.bgcolor("lightgreen")

# t = turtle.Turtle()
# t.fillcolor('blue') 
# t.pencolor('blue')
# t.pensize(3)
# t.shape("turtle")

# def draw_star(t, length):
#   for i in range(5):
#     t.forward(length)
#     t.right(144)
# draw_star(t, 100)
# turtle.done()

#Zad. 6.
# turtle.color("yellow")
# turtle.bgcolor("darkblue")
# turtle.speed(0)
# turtle.hideturtle()

# def starmaker(step,angle):
#     for iter in range(5):
#         turtle.forward(step)
#         turtle.right(angle)

# for i in range(5):
#     turtle.penup()
#     turtle.setpos(random.randint(-250, 350), random.randint(10, 30))
#     turtle.pendown()
#     starmaker(20,144)
# turtle.done()

#Zad. 7
# window = turtle.Screen()
# window.bgcolor("lightgreen")

# t = turtle.Turtle()
# t.pencolor("blue")
# t.shape("turtle")
# t.pensize(2)

# side = 200
# for i in range(100):
#    t.right(-90)
#    t.back(side)
#    side = side - 2

# turtle.done()

#Zad. 8
# window = turtle.Screen()
# window.bgcolor("lightgreen")

# t = turtle.Turtle()
# t.pencolor("blue")
# t.pensize(2)

# turtle.goto(0,200)
# turtle.goto(200,200)
# turtle.right(90)
# turtle.goto(0,0)
# turtle.goto(200,0)
# turtle.left(-180)
# turtle.goto(0,200)
# turtle.goto(100,300)
# turtle.goto(200,200)
# turtle.right(180)
# turtle.goto(200,0)
# turtle.done()

#Zad. 9