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

            result= self.dfs(nodes,target,visited)   
            if result: 
                return result  
        
        self.backtrack()
        return None #hedef bulunamazsa 
    
    def bfs(self, nodes, target):
        queue = [(self.currentNode, [self.currentNode])]  # Kuyruğa başlıyoruz, başlangıç node'u ekleniyor
        visited = set()  # Ziyaret edilen node'ları tutmak için boş bir set oluşturuyoruz
        visited.add(self.currentNode)  # Başlangıç node'unu ziyaret edilmiş olarak işaretliyoruz
        
        while self.queue_index < len(queue):  # Kuyrukta işlem yapılacak eleman kaldığı sürece döngü devam eder
            current, path = queue[self.queue_index]  # Kuyruğun başındaki elemanı alıyoruz (current: node, path: o node'a kadar gittiğimiz yol)
            self.queue_index += 1  # Sıradaki elemanı işlemeye geçiyoruz
            
            if current == target:  # Eğer şu anki node hedef node ise
                return path  # Hedef node'a ulaştık, o zamanki yolu (path) döndürüyoruz
            
            # Şu anki node'un komşularını kontrol ediyoruz
            for neighbor in nodes.get(current, []):  # current node'un komşularını alıyoruz (default boş liste)
                if neighbor not in visited:  # Eğer komşu daha önce ziyaret edilmediyse
                    visited.add(neighbor)  # Bu komşuyu ziyaret edilenler listesine ekliyoruz
                    queue.append((neighbor, path + [neighbor]))  # Komşuyu kuyruğa ekliyoruz ve yolumuza ekliyoruz
        
        return None  # Eğer hedef node'a ulaşamamışsak, None döndürüyoruz



if __name__ == "__main__":
    testTravelar = Travler("a")
    visited=[]
    target= "e"
      
    
    print(testTravelar.roads(nodes))
    testTravelar.walk(nodes)
    print(testTravelar.roads(nodes))
    testTravelar.walk(nodes)
    print(testTravelar.memo)
    print(testTravelar.dfs(nodes,target,visited))
        