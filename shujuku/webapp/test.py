# -*- encoding:utf-8 -*-
a = ((1, 1, '高级', '空房', 'alice', None), (2, 2, '高级', '空房', 'robe', None), (3, 3, '普通', '空房', 'alice', None),
     (4, 4, '普通', '空房', 'yue', None), (5, 5, '普通', '空房', 'yue', None), (6, 6, '普通', '空房', 'yue', None))
a = dict(map(dict, a))
print(a)
