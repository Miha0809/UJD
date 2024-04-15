class Vector:
	_ile = 0
	
	def __init__(self, rozmiar = 3, lista = []):
		self._rozmiar = rozmiar
		self._vect = []
		for i in lista:
			self._vect.append(i)
		Vector._ile += 1
		
	def __del__(self):
		Vector._ile -= 1
		
	def get_ile(cls):
		return cls._ile
		
	def length(self):
		return self._rozmiar	
		
	def __add__(self, other):
		if self._rozmiar != other._rozmiar:	
			raise ValueError('Różne rozmiary wektorów!')
		V = Vector(self._rozmiar)
		for i in range( self._rozmiar):
			V._vect.append(self._vect[i])
		for i in range(self._rozmiar):
			V._vect[i] += other._vect[i]
		return V	
		
	def __mul__(self, alpha):
		V = Vector(self._rozmiar)
		for i in range( self._rozmiar):
			V._vect.append(self._vect[i])
		for i in range(self._rozmiar):
			V._vect[i] *= alpha
		return V		
		
	def sum(self):
		return sum(self._vect)	
		
	def __getitem__(self, i):
		return self._vect[i]
		
	def __ne__(self, other):
		if self._rozmiar != other._rozmiar:
			return True
		for i in range(self._rozmiar):
			if self._vect[i] != other._vect[i]:
				return True
		return False
			
		
	def __contains__(self, element):
		return element in self._vect		
			
	def __str__(self):
		s = '['
		for  i in self._vect[:-1]:
			s += str(i) + ', '
		s += str(self._vect[-1]) + ']'	
		return s
		
class NameVector(Vector):
	def __init__(self, rozmiar, lista, nazwa):
		Vector.__init__(self, rozmiar, lista)
		self._name = nazwa
		
	@property
	def name(self):
		return self._name
		
	@name.setter
	def name(self, new_name):
		self._name = new_name
						
	def __str__(self):
		s = self._name + ' = ['

		for  i in self._vect[:-1]:
			s += str(i) + ', '

		s += str(self._vect[-1]) + ']'
		
		return s		
		 
