let vm = new Vue({
    el: '#main-container',
    data: function () {
        return {
            pageInfo: {
                pageNum: 1,
                pageSize: 5
            },
            setting: {
                data: {
                    simpleData: {
                        enable: true,
                        pIdKey: 'parentId'//根据node节点中的parentId属性来作为pId属性值
                    }
                },
                callback: {
                    // beforeClick:this.beforeClick,
                    onClick: this.onClick
                }
            },
            nodes: [],
            treeObj: {},
            params: {
                pageNum: '',
                pageSize: '',
                areaName: '',
                aid:0
            }
        }
    }, methods: {
        initTree: function () {//初始化ztree
            //获取nodes
            axios({
                url: "manager/sysarea/selectAllArea"
            }).then(response => {
                this.nodes = response.data;//   this.setNodes(.....)

                this.treeObj = $.fn.zTree.init($("#treeMenu"), this.setting, this.nodes);
                console.log(this.treeObj);

            }).catch(function (error) {
                layer.msg(error);
            })
        },
        onClick: function (event, treeId, treeNode) {
            this.params.aid = treeNode.id;
            this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize)
            // console.log(11)
        },
        selectByPage:function (pageNum, pageSize) {
            this.params.pageNum = pageNum
            this.params.pageSize = pageSize
            axios({
                url: "manager/sysarea/selectByPage",
                method:"post",
                data:this.params
            }).then(response =>{
                this.pageInfo = response.data
                console.log(response.data)
            }).catch()
        },
        selectAll:function (pageNum,pageSize) {
            this.params={areaName: '', aid:0}
            this.selectByPage(pageNum,pageSize)
        },
        toUpdate:function (id) {
            axios({
                url:"manager/sysarea/selectById",
                params:{id:id}
            }).then(response =>{
                layer.obj = response.data
                let index = layer.open({
                   type:2,
                   title:"",
                   content:"html/area/save.html",
                    area:['80%','80%'],
                    end: () =>{
                        this.selectByPage(this.pageInfo.pageNum,this.pageInfo.pageSize)
                    }
                });
            }).catch()
        }

    },
    mounted: function () {
        this.initTree();
    },
    created:function () {
        this.selectByPage(this.pageInfo.pageNum,this.pageInfo.pageSize)
    }
})