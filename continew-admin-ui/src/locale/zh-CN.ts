import localeMessageBox from '@/components/message-box/locale/zh-CN';
import localeLogin from '@/views/login/locale/zh-CN';

import localeWorkplace from '@/views/dashboard/workplace/locale/zh-CN';

import localeMonitor from '@/views/dashboard/monitor/locale/zh-CN';

import localeDataAnalysis from '@/views/visualization/data-analysis/locale/zh-CN';
import localeMultiDAnalysis from '@/views/visualization/multi-dimension-data-analysis/locale/zh-CN';

import localeRole from '@/views/system/role/locale/zh-CN';
import localeDept from '@/views/system/dept/locale/zh-CN';

import localeOnlineUser from '@/views/monitor/online/locale/zh-CN';
import localeLoginLog from '@/views/monitor/log/login/locale/zh-CN';
import localeOperationLog from '@/views/monitor/log/operation/locale/zh-CN';
import localeSystemLog from '@/views/monitor/log/system/locale/zh-CN';

import localeSearchTable from '@/views/list/search-table/locale/zh-CN';
import localeCardList from '@/views/list/card/locale/zh-CN';

import localeStepForm from '@/views/form/step/locale/zh-CN';
import localeGroupForm from '@/views/form/group/locale/zh-CN';

import localeBasicProfile from '@/views/profile/basic/locale/zh-CN';

import localeSuccess from '@/views/result/success/locale/zh-CN';
import localeError from '@/views/result/error/locale/zh-CN';

import locale403 from '@/views/exception/403/locale/zh-CN';
import locale404 from '@/views/exception/404/locale/zh-CN';
import locale500 from '@/views/exception/500/locale/zh-CN';

import localeUserCenter from '@/views/system/user/center/locale/zh-CN';

import localeSettings from './zh-CN/settings';

export default {
  'title': 'ContiNew Admin',
  'menu.dashboard': '仪表盘',
  'menu.server.dashboard': '仪表盘-服务端',
  'menu.server.workplace': '工作台-服务端',
  'menu.server.monitor': '实时监控-服务端',
  'menu.visualization': '数据可视化',
  'menu.system': '系统管理',
  'menu.monitor': '系统监控',
  'menu.list': '列表页',
  'menu.form': '表单页',
  'menu.profile': '详情页',
  'menu.result': '结果页',
  'menu.exception': '异常页',
  'menu.user': '个人中心',
  'menu.arcoWebsite': 'Arco Design',
  'menu.faq': '常见问题',
  'navbar.docs': '文档中心',
  'navbar.action.locale': '切换为中文',
  ...localeSettings,
  ...localeMessageBox,
  ...localeLogin,
  ...localeWorkplace,
  ...localeMonitor,
  ...localeDataAnalysis,
  ...localeMultiDAnalysis,

  ...localeRole,
  ...localeDept,

  ...localeOnlineUser,
  ...localeLoginLog,
  ...localeOperationLog,
  ...localeSystemLog,

  ...localeSearchTable,
  ...localeCardList,
  ...localeStepForm,
  ...localeGroupForm,
  ...localeBasicProfile,
  ...localeSuccess,
  ...localeError,
  ...locale403,
  ...locale404,
  ...locale500,
  ...localeUserCenter,
};
