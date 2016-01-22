'''
Created on Jan 22, 2016

@author: dnance
'''

class BlobBoundaryFinder:
    """Finds the top, bottom, left, and right boundaries for a 10X10 blob"""
    
    top = 0
    bottom = 9
    left = 0
    right = 9
    blob = [[]]
    totalReads = 0
    
    
    def __init__(self, blob):
        self.blob = blob
        self.findTop()
        self.findBottom()
        self.findLeft()
        self.findRight()

    def readBlob(self, i, j):
        self.totalReads= self.totalReads + 1
        return self.blob[i][j]
    
        
    def findTop(self):
        """Finds the top boundary"""
        foundBoundary = False
        for i in range(0, self.bottom):
            if not foundBoundary:
                for j in range(self.left, self.right):
                    value = self.readBlob(i,j)
                    if value == 1:
                        self.top = i
                        foundBoundary = True
                        break
        return
            
    def findBottom(self):
        """Finds the bottom boundary"""
        foundBoundary = False
        for i in reversed(range(0,10)):
            if not foundBoundary:
                for j in range(self.left, self.right):
                    value = self.readBlob(i,j)
                    if value == 1:
                        self.bottom = i
                        foundBoundary = True
                        break
        return

    def findLeft(self):
        """Finds the left boundary"""
        foundBoundary = False
        for j in range(0, 10):
            if not foundBoundary:
                for i in range(self.top,self.bottom):
                    value = self.readBlob(i,j)
                    if value == 1:
                        self.left = j
                        foundBoundary = True
                        break
        return
    
    def findRight(self):
        """Finds the right boundary"""
        foundBoundary = False
        for j in reversed(range(0,10)):
            if not foundBoundary:
                for i in range(self.left,self.right):
                    value = self.readBlob(i,j)
                    if value == 1:
                        self.right = j
                        foundBoundary = True
                        break
        return
    
                        
if __name__ == '__main__':
    blob = [[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                [ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 ],
                [ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 ],
                [ 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 ],
                [ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 ],
                [ 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 ],
                [ 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 ],
                [ 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 ],
                [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
                [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ] ];
                
    finder = BlobBoundaryFinder(blob)
    print "Cell reads: ", finder.totalReads
    print "Top: ", finder.top
    print "bottom: ", finder.bottom
    print "left: ", finder.left
    print "right: ", finder.right
    
                
