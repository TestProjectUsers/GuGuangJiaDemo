let vm = new Vue({
    el: "#main-container",
    data: {
        pageInfo:{
            pageNum:1,
            pageSize:5
        },
        params:{
            pageNum:'',
            pageSize:'',
            type:''
        },
        statute:{},
        myConfig: {
            // 如果需要上传功能,找后端小伙伴要服务器接口地址
            serverUrl: 'http://localhost:8090/ueditor/ueditorConfig',
            // 你的UEditor资源存放的路径  path是全局声明的应用路径
            //'/static/ueditor/'是应用下存放ueditor文件位置注意最后一个"/"不能省略
            UEDITOR_HOME_URL: 'static/ueditor/',
            // 编辑器不自动被内容撑高
            autoHeightEnabled: false,
            // 工具栏是否可以浮动
            autoFloatEnabled: false,
            // 初始容器高度
            initialFrameHeight: 340,
            // 初始容器宽度
            initialFrameWidth: '100%',
            // 关闭自动保存
            enableAutoSave: true,
            // 上传文件接口（
            serverUrl: 'ueditor/execute'
        },
    }, methods: {
        selectAll:function (pageNum,pageSize) {
            this.params.pageNum=pageNum
            this.params.pageSize=pageSize
            axios({
                url:"manager/statute/selectAll",
                method: "post",
                data: this.params
            }).then(response =>{
                this.pageInfo = response.data
                console.log(response.data)
            }).catch(function (error) {
                console.log(error)
            })
        },
        selectNoCondition:function (pageNum, pageSize) {
            this.params={type:''}
            this.selectAll(pageNum,pageSize)
        },
        insertMsg:function () {
            axios({
                url: "manager/statute/insertMsg",
                method: "post",
                data:this.statute
            }).then(response =>{
                console.log(response.data)
                if (response.data==1){
                    console.log(response.data.success)
                    this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize)
                    this.statute={}
                }
            }).catch(function (error) {
                console.log(error)
            })
        },
        toUpdate:function (id) {
            axios({
                url:"manager/statute/toUpdate",
                params:{id:id}
            }).then(response =>{
                layer.statute = response.data
                console.log(layer)
                console.log(layer.statute)
                let index = layer.open({
                    type: 2,
                    title: '更新数据',
                    content: 'html/statute/update.html',
                    area: ['80%', '80%'],
                    end: () => {
                        this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize)
                    }
                });
            }).catch()
        }
    },
    components: {
        VueUeditorWrap
    },
    created:function () {
        this.selectAll(this.params.pageNum,this.params.pageSize)
    }
});