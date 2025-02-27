import heapq

def solution(n, paths, gates, summits):
    # 그래프 구성
    graph = [[] for _ in range(n + 1)]
    for i, j, w in paths:
        graph[i].append((j, w))
        graph[j].append((i, w))
    
    # 세트로 변환하여 O(1) 시간 복잡도로 검색 가능
    summit_set = set(summits)
    gate_set = set(gates)
    
    # 모든 출입구에서 동시에 시작하는 다익스트라 알고리즘
    INF = int(1e9)
    intensity = [INF] * (n + 1)
    q = []
    
    # 모든 출입구를 시작점으로 큐에 넣기
    for gate in gates:
        intensity[gate] = 0
        heapq.heappush(q, (0, gate))
    
    # 가장 작은 산봉우리와 강도 추적
    min_intensity = INF
    min_summit = 0
    
    # 다익스트라 알고리즘 실행
    while q:
        intens, now = heapq.heappop(q)
        
        # 현재 경로가 이미 찾은 최소 강도보다 크면 더 이상 탐색할 필요 없음
        if intens > min_intensity:
            continue
            
        # 현재 지점의 강도가 이미 계산된 강도보다 크면 스킵
        if intens > intensity[now]:
            continue
        
        # 산봉우리에 도달한 경우
        if now in summit_set:
            if intens < min_intensity or (intens == min_intensity and now < min_summit):
                min_intensity = intens
                min_summit = now
            continue  # 산봉우리에서 더 이상 탐색하지 않음
        
        # 다음 지점 탐색
        for next_node, next_intens in graph[now]:
            # 출입구로는 가지 않음
            if next_node in gate_set:
                continue
                
            # 경로의 강도는 현재까지의 최대 강도
            new_intens = max(intens, next_intens)
            
            # 더 좋은 경로를 찾은 경우에만 업데이트
            if new_intens < intensity[next_node]:
                intensity[next_node] = new_intens
                heapq.heappush(q, (new_intens, next_node))
    
    return [min_summit, min_intensity]
