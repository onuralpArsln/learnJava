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
        return nodes[self.currentNode]  # özel durumları yönet sözlükte key olmayan nodelar var mı mesela h
    
    def walk(self,nodes):
        self.currentNode = self.roads(nodes)[0] 
        self.memo.append(self.currentNode)
    
    def backtrack(self):
        self.memo.pop()
        self.currentNode = self.memo[-1]

    def dfs(self,nodes,target,visited):
      
        
        if self.currentNode == target: 
            return self.memo #baştan yapıyoz ki aramasın targetsa
        
        for i in self.roads(nodes): #i gidebileceğimiz node
            if i in visited:
                continue
            self.currentNode = i
            self.memo.append(i)
            visited.append(i)

        if self.dfs(nodes,target,visited): 
             return self.dfs(nodes,target,visited) #bulduysa sonucu returnle
        
        self.backtrack()
        return None #hedef bulunamazsa 


if __name__ == "__main__":
    testTravelar = Travler("a")
    visited=[]
    target= "b"
      
    
    print(testTravelar.roads(nodes))
    testTravelar.walk(nodes)
    print(testTravelar.roads(nodes))
    testTravelar.walk(nodes)
    print(testTravelar.memo)
    print(testTravelar.dfs(nodes,target,visited))
        