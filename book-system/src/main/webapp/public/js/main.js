function logout(){
    $.ajax({
        url: "user/logout",
        contentType: "application/json",
        success: function (r) {
            showSuccessModal("注销成功", function () {
                window.location.href = "public/index.html";
            }, 1500);
        },
        error: function (error) {
            showError(error);
        }
    });
    return false;
}

/**
 * 班级管理
 */
let classesTabOptions = {
    id: "classes_table",//表格id
    url:'classes/query',//表格查询url
    toolbar: [{
        type: "add",//新增按钮
        title: "新增班级",//弹出框标题
        url: "classes/add",//弹出框提交url
        invisible:["createTime"],//弹出框不展示的字段
    },{
        type: "update",//修改按钮
        title: "修改班级",
        queryUrl: "classes/queryById",//弹出框初始化数据url
        url: "classes/update",
        // invisible:["createTime"],
    },{
        type: "delete",//删除按钮
        url: "classes/delete",
    }],
    columns: [{
        checkbox: true
    },{
        title: '班级名称',
        field: "classesName",
        switchable: false,//表格是否允许不展示列
        sortable: true,//表格字段是否可排序
        required: true,//新增/修改时，字段是否必填
        tooltip: "请输入班级名称",//提交时字段验证提示内容
    },{
        title: '毕业年份',
        field: 'classesGraduateYear',
        type: "select",//新增/修改时，字段为下拉菜单
        dictionaryKey: "000001",//数据字典键
    },{
        title: '专业',
        field: 'classesMajor',
        // submitName: 'classesMajor',//新增/修改提交的字段名
        type: "select",//新增/修改时，字段为下拉菜单
        dictionaryKey: "000002",//数据字典键
    },{
        title: '描述',
        field: 'classesDesc',
    },{
        title: '创建时间',
        field: 'createTime',
        type: "datetime",
        disabled: true,
    }],
};

/**
 * 学生管理
 */
let stuTabOptions = {
    id: "stu_table",//表格id
    url:'student/query',//表格查询url
    toolbar: [{
        type: "add",//新增按钮
        title: "新增学生",//弹出框标题
        url: "student/add",//弹出框提交url
        invisible:["classes.classesName", "createTime"],//弹出框不展示的字段
    },{
        type: "update",//修改按钮
        title: "修改学生",
        queryUrl: "student/queryById",//弹出框初始化数据url
        url: "student/update",
        invisible:["classes.classesName"],
    },{
        type: "delete",//删除按钮
        url: "student/delete",
    }],
    columns: [{
        checkbox: true
    },{
        title: '姓名',
        field: "studentName",
        switchable: false,//表格是否允许不展示列
        sortable: true,//表格字段是否可排序
        required: true,//新增/修改时，字段是否必填
        tooltip: "请输入学生姓名",//提交时字段验证提示内容
    },{
        title: '学号',
        field: 'studentNo',
    },{
        title: '身份证号',
        field: 'idCard',
    },{
        title: '班级',
        field: 'classes.classesName',
    },{
        title: '班级',
        field: 'classes.id',
        submitName: 'classesId',//新增/修改提交的字段名
        type: "select",//新增/修改时，字段为下拉菜单
        url: "classes/queryAsDict",//新增/修改时，下拉菜单初始化数据url
        visible: false,//表格不显示，新增/修改弹出框使用
        switchable: false,//表格是否允许不展示列
        search: true,//下拉菜单是否可搜索
        // required: true,//新增/修改时，字段是否必填
        // tooltip: "请选择班级",//提交时字段验证提示内容
    },{
        title: '毕业年份',
        field: 'classes.classesGraduateYear',
        // submitName: 'classesGraduateYear',//新增/修改提交的字段名
        type: "select",//新增/修改时，字段为下拉菜单
        dictionaryKey: "000001",//数据字典键
        disabled: true,//表单元素为禁用时，提交表单时不会包含禁用元素数据
        // readonly: true,//表单元素为只读时，提交表单时会包含只读元素数据
        relatedSelect: "classes.id",
        relatedField: "classesGraduateYear",//级联菜单url查询出的数据，关联字段
    },{
        title: '专业',
        field: 'classes.classesMajor',
        // submitName: 'classesMajor',//新增/修改提交的字段名
        type: "select",//新增/修改时，字段为下拉菜单
        dictionaryKey: "000002",//数据字典键
        disabled: true,//表单元素为禁用时，提交表单时不会包含禁用元素数据
        // readonly: true,//表单元素为只读时，提交表单时会包含只读元素数据
        relatedSelect: "classes.id",
        relatedField: "classesMajor",//级联菜单url查询出的数据，关联字段
    },{
        title: '邮箱',
        field: 'studentEmail',
    },{
        title: '创建时间',
        field: 'createTime',
        type: "datetime",
        disabled: true,
        // formatter: function(value, item, index) {
        //     return value;
        // },
    }],
};

/**
 * 图书管理
 */
let bookTabOptions = {
    id: "book_table",//表格id
    url:'book/query',//表格查询url
    toolbar: [{
        type: "add",//新增按钮
        title: "新增图书",//弹出框标题
        url: "book/add",//弹出框提交url
        invisible:["createTime"],//弹出框不展示的字段
    },{
        type: "update",//修改按钮
        title: "修改图书",
        queryUrl: "book/queryById",//弹出框初始化数据url
        url: "book/update",
        // invisible:["createTime"],
    },{
        type: "delete",//删除按钮
        url: "book/delete",
    }],
    columns: [{
        checkbox: true
    },{
        title: '图书名称',
        field: 'bookName',
        switchable: false,//表格是否允许不展示列
        sortable: true,//表格字段是否可排序
        required: true,//新增/修改时，字段是否必填
        tooltip: "请输入图书名称",//提交时字段验证提示内容
    },{
        title: '作者',
        field: 'author',
    },{
        title: '价格',
        field: 'price',
    },{
        title: '创建时间',
        field: 'createTime',
        type: "datetime",
        disabled: true,
    }],
};

/**
 * 借阅信息管理
 */
let borrowRecordTabOptions = {
    id: "borrow_record_table",//表格id
    url:'borrowRecord/query',//表格查询url
    toolbar: [{
        type: "add",//新增按钮
        title: "新增借阅信息",//弹出框标题
        url: "borrowRecord/add",//弹出框提交url
        invisible:["classes.classesName", "student.studentName", "book.bookName", "createTime"],//弹出框不展示的字段
    },{
        type: "update",//修改按钮
        title: "修改借阅信息",
        queryUrl: "borrowRecord/queryById",//弹出框初始化数据url
        url: "borrowRecord/update",
        invisible:["classes.classesName", "student.studentName", "book.bookName"],
    },{
        type: "delete",//删除按钮
        url: "borrowRecord/delete",
    }],
    columns: [{
        checkbox: true
    },{
        title: '班级',
        field: 'classes.classesName',
    },{
        title: '班级',
        field: 'classes.id',
        noneSubmit: true,//新增/修改不提交字段
        type: "select",//新增/修改时，字段为下拉菜单
        url: "classes/queryAsDict",//新增/修改时，下拉菜单初始化数据url
        visible: false,//表格不显示，新增/修改弹出框使用
        switchable: false,//表格是否允许不展示列
        search: true,//下拉菜单是否可搜索
    },{
        title: '学生姓名',
        field: 'student.studentName',
    },{
        title: '学生姓名',
        field: 'student.id',
        submitName: 'studentId',//新增/修改提交的字段名
        type: "select",//新增/修改时，字段为下拉菜单
        url: "student/queryAsDict",//新增/修改时，下拉菜单初始化数据url
        visible: false,//表格不显示，新增/修改弹出框使用
        switchable: false,//表格是否允许不展示列
        search: true,//下拉菜单是否可搜索
        required: true,//新增/修改时，字段是否必填
        tooltip: "请选择学生",//提交时字段验证提示内容
        relatedSelect: "classes.id",
    },{
        title: '专业',
        field: 'classes.classesMajor',
        // submitName: 'classesMajor',//新增/修改提交的字段名
        type: "select",//新增/修改时，字段为下拉菜单
        dictionaryKey: "000002",//数据字典键
        disabled: true,//表单元素为禁用时，提交表单时不会包含禁用元素数据
        // readonly: true,//表单元素为只读时，提交表单时会包含只读元素数据
        relatedSelect: "classes.id",
        relatedField: "classesMajor",//级联菜单url查询出的数据，关联字段
    },{
        title: '毕业年份',
        field: 'classes.classesGraduateYear',
        // submitName: 'classesGraduateYear',//新增/修改提交的字段名
        type: "select",//新增/修改时，字段为下拉菜单
        dictionaryKey: "000001",//数据字典键
        disabled: true,//表单元素为禁用时，提交表单时不会包含禁用元素数据
        // readonly: true,//表单元素为只读时，提交表单时会包含只读元素数据
        relatedSelect: "classes.id",
        relatedField: "classesGraduateYear",//级联菜单url查询出的数据，关联字段
    },{
        title: '学号',
        field: 'student.studentNo',
        disabled: true,
        relatedSelect: "student.id",
        relatedField: "studentNo",//级联菜单url查询出的数据，关联字段
    },{
        title: '身份证号',
        field: 'student.idCard',
        disabled: true,
        relatedSelect: "student.id",
        relatedField: "idCard",//级联菜单url查询出的数据，关联字段
    },{
        title: '图书名称',
        field: 'book.bookName',
    },{
        title: '图书名称',
        field: 'book.id',
        submitName: 'bookId',//新增/修改提交的字段名
        type: "select",//新增/修改时，字段为下拉菜单
        url: "book/queryAsDict",//新增/修改时，下拉菜单初始化数据url
        visible: false,//表格不显示，新增/修改弹出框使用
        switchable: false,//表格是否允许不展示列
        search: true,//下拉菜单是否可搜索
        required: true,//新增/修改时，字段是否必填
        tooltip: "请选择图书",//提交时字段验证提示内容
    },{
        title: '作者',
        field: 'book.author',
        disabled: true,//表单元素为禁用时，提交表单时不会包含禁用元素数据
        relatedSelect: "book.id",
        relatedField: "author",//级联菜单url查询出的数据，关联字段
    },{
        title: '价格',
        field: 'book.price',
        disabled: true,//表单元素为禁用时，提交表单时不会包含禁用元素数据
        relatedSelect: "book.id",
        relatedField: "price",//级联菜单url查询出的数据，关联字段
    },{
        title: '借阅日期',
        field: 'startTime',
        type: "datetime",
        required: true,//新增/修改时，字段是否必填
        tooltip: "请选择借阅日期",//提交时字段验证提示内容
    },{
        title: '归还日期',
        field: 'endTime',
        type: "datetime",
    },{
        title: '创建时间',
        field: 'createTime',
        type: "datetime",
        disabled: true,
        // formatter: function(value, item, index) {
        //     return value;
        // },
    }],
};

/**
 * 用户管理
 */
let userTabOptions = {
    id: "user_table",//表格id
    url:'user/query',//表格查询url
    toolbar: [{
        type: "add",//新增按钮
        title: "新增用户",//弹出框标题
        url: "user/register",//弹出框提交url
        invisible:[],//弹出框不展示的字段
    },{
        type: "update",//修改按钮
        title: "修改用户",
        queryUrl: "user/queryById",//弹出框初始化数据url
        url: "user/update",
        invisible:[],
    },{
        type: "delete",//删除按钮
        url: "user/delete",
    }],
    columns: [{
        checkbox: true
    },{
        title: '用户账号',
        field: "username",
        switchable: false,//表格是否允许不展示列
        sortable: true,//表格字段是否可排序
        required: true,//新增/修改时，字段是否必填
        tooltip: "请输入用户账号",//提交时字段验证提示内容
    },{
        title: '密码',
        field: 'password',
    },{
        title: '用户昵称',
        field: 'nickname',
    },{
        title: '邮箱',
        field: 'email',
    },{
        title: '创建时间',
        field: 'createTime',
        type: "datetime",
        // disabled: true,
        // formatter: function(value, item, index) {
        //     return value;
        // },
    }],
};

$(function () {
    setTableDefaultSettings();
    initNav("main_nav", [{
        id: "classes_tab",
        init: function () {
            initTable(classesTabOptions);
        }
    },{
        id: "stu_tab",
        init: function () {
            initTable(stuTabOptions);
        },
        default: true
    },{
        id: "book_tab",
        init: function () {
            initTable(bookTabOptions);
        },
    },{
        id: "borrow_record_tab",
        init: function () {
            initTable(borrowRecordTabOptions);
        },
    },{
        id: "user_tab",
        init: function () {
            initTable(userTabOptions);
        },
    },{
        id: "settings_tab",
        init: function () {
        },
        active: false
    }]);
});