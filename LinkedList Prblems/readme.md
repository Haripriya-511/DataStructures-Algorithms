## What is a Linked List?

A Linked List is a linear data structure where each element (called a node) points to the next one. Unlike arrays, elements are not stored in continuous memory.

Each node has:
1. Data
2. A pointer to the next node

## Flexibility Over Arrays
   Dynamic Size ✅

Easy Insert/Delete ✅

Less Memory Wastage ✅

Especially useful when:

- You don’t know the data size in advance

- You need frequent insert/delete operations

## 🎯 Summary: When to Use What

- Known fixed size	== Array
- Need fast index access ==	Array
- High cache performance (e.g., large data grid) ==	Array
- Unknown size/growing list ==	Linked List
- Frequent insert/delete (e.g., chat messages, playlist)==Linked List
- Back/Forward (Browser, Text Editor)== Doubly Linked List
- Looping structure (e.g., Music Playlist) ==	Circular Linked List
- Custom memory management (LRU, OS scheduler)==	Linked List



### When to Use Arrays – Real-Life Examples
1. Leaderboards 
2. Pixel grids
3. Binary search on sorted data

### When to Use Linked Lists – Real-Life Examples
1. Shopping carts
2. Music playlist loops
3. Undo/redo
4. LRU Cache
5. Round-robin scheduling
