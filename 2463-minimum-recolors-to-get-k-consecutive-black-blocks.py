class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        n = len(blocks)
        black = 0
        min_recoloring = float('inf')

        for i in range(n):
            if blocks[i] == 'B':
                black += 1
            if i >= k - 1:
                min_recoloring = min(k - black, min_recoloring)
                if blocks[i - k + 1] == 'B':
                    black -= 1

        return min_recoloring
