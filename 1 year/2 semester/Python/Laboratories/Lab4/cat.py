""" Module cat """


class Cat:
    """ Cat """

    def __init__(self, name: str = "Filemon", favorites: list = "mouse", disliked: list = "cat"):
        """ Constructor """
        self.name: str = name
        self.favorites: list = [favorites]
        self.disliked: list = [disliked]

    def say_hello(self) -> str:
        """ przywitaj się """
        return f"{self.name} miauczeć " * 3


    def representation(self) -> str:
        """ przedstaw się """
        return (f"Name: {self.name}" +
                f"Age: {5}")

    def write_favorites(self) -> str:
        """ pisz ulubione """
        print(f"I have {len(self.favorites)} favorite toys. And here they are: {self.favorites}")

    def write_disliked(self) -> None:
        """ pisz nielubiane """
        print(f"I have {len(self.disliked)} toys that I don't like. Here they are: {self.disliked}")

    def likes(self, toy: str) -> None:
        """ polubienie """
        if toy in self.disliked:
            self.disliked.remove(toy)

        if toy not in self.favorites:
            self.favorites.append(toy)

    def takes_offense(self, toy: str) -> None:
        """ obraza """
        if toy in self.favorites:
            self.favorites.remove(toy)
        
        if toy not in self.disliked:
            self.disliked.append(toy)

    def __str__(self) -> str:
        return (f"Name: {self.name}\n"
                f"Favorite: {self.favorites}\n"
                f"Disliked: {self.disliked}")
