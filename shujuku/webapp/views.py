import pymysql
from django.http import HttpResponseRedirect, JsonResponse
from django.shortcuts import render
from pymysql.cursors import DictCursor

# 打开数据库连接
db = pymysql.connect(
    host='127.0.0.1',  # 连接主机, 默认127.0.0.1
    user='root',  # 用户名
    passwd='196786',  # 密码
    port=3306,  # 端口，默认为3306
    db='shujuku',  # 数据库名称
    charset='utf8'  # 字符编码
)

# 使用 cursor() 方法创建一个游标对象
cursor = db.cursor(cursor=pymysql.cursors.DictCursor)


# Create your views here.
def index(request):
    return render(request, "index.html")


def login(request):
    # 使用 cursor() 方法创建一个游标对象
    cursor = db.cursor(cursor=pymysql.cursors.DictCursor)
    username = request.POST.get("username")
    password = request.POST.get("password")

    sql = f"select * from user where username='{username}' and password='{password}'"
    execute = cursor.execute(sql)

    if execute > 0:
        execute = 1

    cursor.close()

    return JsonResponse({"status": execute, "msg": "/show/"})


def show(request):
    # 使用 cursor() 方法创建一个游标对象
    cursor = db.cursor(cursor=pymysql.cursors.DictCursor)
    sql_kong = f"select * from room where status='空房'"
    cursor.execute(sql_kong)
    kong = list(cursor.fetchall())

    sql_man = f"select * from room where status='已预订'"
    cursor.execute(sql_man)
    man = list(cursor.fetchall())

    cursor.close()

    return render(request, "show.html", {"kongfangs": kong, "manfangs": man})


def yuding(request):
    # 使用 cursor() 方法创建一个游标对象
    cursor = db.cursor(cursor=pymysql.cursors.DictCursor)
    roomId = request.GET.get("roomId")

    sql = f"update room set status='已预订' where roomId='{roomId}'"
    cursor.execute(sql)

    # 再将目标房间改成已预订
    sql4 = f"update room set userName='admin' where roomId='{roomId}'"
    cursor.execute(sql4)

    db.commit()
    cursor.close()

    return HttpResponseRedirect("/show/")


def tuifang(request):
    # 使用 cursor() 方法创建一个游标对象
    cursor = db.cursor(cursor=pymysql.cursors.DictCursor)
    roomId = request.GET.get("roomId")

    sql = f"update room set status='空房' where roomId='{roomId}'"
    cursor.execute(sql)

    # 换房时首先将原房释放
    sql3 = f"update room set userName='空' where roomId='{roomId}'"
    cursor.execute(sql3)
    db.commit()
    cursor.close()

    return HttpResponseRedirect("/show/")


def huanfang(request):
    oldRoomId = request.GET.get("roomId")
    # 使用 cursor() 方法创建一个游标对象
    cursor = db.cursor(cursor=pymysql.cursors.DictCursor)
    if oldRoomId:
        sql_kong = f"select * from room where status='空房'"
        cursor.execute(sql_kong)
        kong = list(cursor.fetchall())

        cursor.close()

        return render(request, "change.html", {"rooms": kong, "oldRoomId": oldRoomId})
    else:
        oldId = request.GET.get("oldId")
        newId = request.GET.get("newId")

        # 换房时首先将原房释放
        sql1 = f"update room set status='空房' where roomId='{oldId}'"
        cursor.execute(sql1)

        # 再将目标房间改成已预订
        sql2 = f"update room set status='已预订' where roomId='{newId}'"
        cursor.execute(sql2)
        db.commit()


        # 用户信息修改
        # 换房时首先将原房释放
        sql3 = f"update room set userName='空' where roomId='{oldId}'"
        cursor.execute(sql3)

        # 再将目标房间改成已预订
        sql4 = f"update room set userName='admin' where roomId='{newId}'"
        cursor.execute(sql4)
        db.commit()

        cursor.close()

        return HttpResponseRedirect("/show/")


def searchById(request):
    room_id = request.POST.get("room_id")
    # 使用 cursor() 方法创建一个游标对象
    cursor = db.cursor(cursor=pymysql.cursors.DictCursor)

    sql = f"select * from room where roomId={room_id}"
    cursor.execute(sql)
    rooms = cursor.fetchall()
    cursor.close()
    return render(request, "search_result.html", {"rooms": rooms})


def SearchByUser(request):
    user_name = request.POST.get("userName")
    # 使用 cursor() 方法创建一个游标对象
    cursor = db.cursor(cursor=pymysql.cursors.DictCursor)

    sql = f"select * from room where userName='{user_name}'"
    cursor.execute(sql)
    rooms = cursor.fetchall()
    cursor.close()
    return render(request, "search_result.html", {"rooms": rooms})
