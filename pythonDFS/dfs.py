nodes ={"a":["b","c"], 
        "b":["c","d"],
        "c":["e"],
        "d":["e","f","g"],
        "e":["f","h"],
        "f":["g","h"]} # g ve h farklı uygulamalarda hedef nodlar gh başka yere gidilemiyo :(

class Travler:

    def __init__(self,currentNode):
        self.currentNode= currentNode
        self.memo=[currentNode]
    
    def roads(self,nodes):
        if self.currentNode in nodes:
            return nodes[self.currentNode]
        else:
            return [] 
        
    def walk(self,nodes):
        self.currentNode = self.roads(nodes)[0] 
        self.memo.append(self.currentNode)
    
    def backtrack(self):
     if len(self.memo):        #ya tutarsa type thing
        self.memo.pop()
        self.currentNode = self.memo[-1]

    def bfs(self,nodes,target):
        queue =[]
        visited = set()
        queue.append([self.currentNode])

        while len(queue)>0:
            path=queue[0]
            
            for i in nodes[path[-1]]:
                
                if i in visited:
                    continue
                visited.add(i)
                
                temp_path = path.copy()
                temp_path.append(i)
                queue.append(temp_path)
                
                if i == target:
                    return temp_path
                
            queue.pop(0)
        return []          

    def dfs(self,nodes,target):
      
        visited = set()      #yine de bi baksak mı 

        
        if self.currentNode == target: 
            return self.memo #baştan yapıyoz ki aramasın targetsa
        
        for i in self.roads(nodes): #i gidebileceğimiz node
            if i in visited:
                continue
            self.currentNode = i
            self.memo.append(i)
            visited.add(i)

            result= self.dfs(nodes,target)   
            if result: 
                return result  
            
            while set(self.roads(nodes)).issubset(visited):
                self.backtrack()
                print("backed")
        return None #hedef bulunamazsa 

if __name__ == "__main__":
    testTravelar = Travler("a")
    target= "e"

    print(testTravelar.roads(nodes))
    testTravelar.walk(nodes)
    print(testTravelar.roads(nodes))
    testTravelar.walk(nodes)
    print(testTravelar.memo)
    print("dfs ile g gidiyok")
    testTravelar.currentNode="a"
    print(testTravelar.dfs(nodes,"g"))
    print("dfs ile h gidiyok")
    testTravelar.currentNode="a"
    print(testTravelar.dfs(nodes,"h"))
    print("bfs ile g gidiyok")
    testTravelar.currentNode="a"
    print(testTravelar.bfs(nodes,"g"))
    print("bfs ile h gidiyok")
    testTravelar.currentNode="a"
    print(testTravelar.bfs(nodes,"h"))